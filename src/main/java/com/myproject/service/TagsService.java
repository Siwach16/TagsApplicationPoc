package com.myproject.service;


import com.myproject.dao.TagsDao;
import com.myproject.models.Tag;
import lombok.Setter;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;
import java.util.Set;


/**
 * Created by tat50037 on 18/12/18.
 */
@Singleton
@Setter
public class TagsService {
    @Inject
    TagsDao tagsDao;

    public String addTag(Tag tag){
        return tagsDao.addTag(tag);
    }

    public Tag getTagByName(String tagName){
        return tagsDao.getTagByName(tagName);
    }

    public List<Tag> getAllTags(){
        return tagsDao.getAllTags();
    }
    public List<Tag> getAllTags(List<String> ids){
        return tagsDao.getAllTags(ids);
    }

    public Set<Tag> getAllParentTags(List<String> ids) {
        return tagsDao.getAllParentTags(ids);
    }

    public Tag getTagById(String id) {

        return tagsDao.getTagById(id);
    }
}
