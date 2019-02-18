package com.myproject.dao;

import com.myproject.models.Tag;

import java.util.List;
import java.util.Set;

/**
 * Created by tat50037 on 17/12/18.
 */
public interface TagsDao {
    String addTag(Tag tag);
    void addTags(List<Tag> tag);
    Tag getTagByName(String tagName);
    Tag getTagById(String id);
    Set<Tag> getAllParentTags(List<String> ids);
    List<Tag> getAllTags();

    List<Tag> getAllTags(List<String> ids);
}
