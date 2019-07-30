package com.beerdemo.demo.services;

import com.beerdemo.demo.entities.Tag;
import com.beerdemo.demo.repositories.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TagServiceImpl implements TagService {
    TagRepository repository;
@Autowired
    public TagServiceImpl(TagRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Tag> getAllTags() {
 return repository.getAllTags();
    }
}