package com.myproject.dao;

import com.myproject.models.Tag;

import java.util.List;

/**
 * Created by tat50037 on 17/12/18.
 */
public interface TagsDao {
    String addTag(Tag tag);
    void addTags(List<Tag> tag);
    Tag getTag(String tagName);
    List<Tag> getTags(List<Tag> tag);
    List<Tag> getAllTags();
}
