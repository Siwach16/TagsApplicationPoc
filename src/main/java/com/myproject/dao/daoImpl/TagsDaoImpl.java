package com.myproject.dao.daoImpl;

import com.myproject.dao.TagsDao;
import com.myproject.models.Tag;
import com.myproject.utils.annotation.Carrier;
import org.mongodb.morphia.Datastore;

import javax.inject.Inject;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by tat50037 on 17/12/18.
 */
public class TagsDaoImpl implements TagsDao {

    @Inject
    @Carrier(value = {"localhost:Tags"})
    Datastore mongoDataStore;

    public String addTag(Tag tag) {
        return mongoDataStore.save(tag).getId().toString();
    }

    public void addTags(List<Tag> tag) {

    }

    public Tag getTag(String tagName) {
        return mongoDataStore.get(Tag.class,tagName);
    }

    public List<Tag> getTags(List<Tag> tag) {
        return null;
    }

    @Override
    public List<Tag> getAllTags() {
        List<Tag> query=mongoDataStore.createQuery(Tag.class).asList();
        return query;
    }
}
