package com.example.Biblioteca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Biblioteca.domain.Post;
import com.example.Biblioteca.service.PostService;

@RestController
@RequestMapping("/postC")
public class PostController {

    @Autowired
    PostService service;

    @GetMapping
    public List<Post> getAll() {
        return service.getAll();
    }

    @GetMapping("{id}")
    public Post getById(@PathVariable("id") Long id) {
        return service.getById(id);
    }

    @PostMapping
    public Post create(@RequestBody Post item) {
        return service.create(item);
    }

    @PutMapping("{id}")
    public Post update(@PathVariable("id") Long id, @RequestBody Post item) {
        return service.update(id, item);
    }

    @DeleteMapping("{id}")
    public boolean delete(@PathVariable("id") Long id) {
        return service.delete(id);
    }
}