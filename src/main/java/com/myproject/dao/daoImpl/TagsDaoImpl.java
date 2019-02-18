package com.myproject.dao.daoImpl;

import com.myproject.dao.TagsDao;
import com.myproject.models.Tag;
import com.myproject.utils.annotation.Carrier;
import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;

import javax.inject.Inject;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by tat50037 on 17/12/18.
 */
public class TagsDaoImpl implements TagsDao {

    @Inject
    @Carrier(value = {"localhost:Tags"})
    Datastore mongoDataStore;

    public String addTag(Tag tag) {
        if(tag.getParentTag().getTagName()!=null && !tag.getParentTag().getTagName().isEmpty()) {
            Tag parentTag = getTagByName(tag.getParentTag().getTagName());
            if (parentTag == null) {
                mongoDataStore.save(tag.getParentTag());
            } else
                tag.setParentTag(parentTag);
        }
        return mongoDataStore.save(tag).getId().toString();
    }

    public void addTags(List<Tag> tag) {

    }


    public Tag getTagByName(String tagName) {
        return mongoDataStore.createQuery(Tag.class).field("tagName").equalIgnoreCase(tagName).get();
    }


    public Tag getTagById(String id) {
        return mongoDataStore.get(Tag.class, new ObjectId(id));
    }


    public Set<Tag> getAllParentTags(List<String> ids) {
        Set<Tag> hierarchy=new HashSet<>();
        for(String id:ids) {
            Tag currTag = getTagById(id);
            hierarchy.add(currTag);
            while (currTag.getParentTag() != null) {
                hierarchy.add(currTag.getParentTag());
                currTag = currTag.getParentTag();
            }
        }
        return hierarchy;
    }

    public List<Tag> getAllTags() {
        List<Tag> query=mongoDataStore.createQuery(Tag.class).asList();
        return query;
    }

    @Override
    public List<Tag> getAllTags(List<String> ids) {
        List<Tag> hierarchy = new ArrayList<>();
        for (String id : ids) {
            Tag currTag = getTagById(id);
            hierarchy.add(currTag);
        }
        return hierarchy;
    }
}
