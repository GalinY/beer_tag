package com.beerdemo.demo.repositories;

import com.beerdemo.demo.entities.Tag;

import java.util.List;

public interface TagRepository {
    List<Tag> getAllTags();
}
