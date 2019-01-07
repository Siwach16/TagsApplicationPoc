package com.myproject.service;


import com.myproject.dao.TagsDao;
import com.myproject.models.Tag;
import lombok.Setter;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;


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

    public Tag getTag(String tagName){
        return tagsDao.getTag(tagName);
    }

    public List<Tag> getAllTags(){
        return tagsDao.getAllTags();
    }

}
