package com.example.Biblioteca.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Biblioteca.domain.Post;
import com.example.Biblioteca.repository.PostRepository;

@Service
public class PostService {

    @Autowired
    PostRepository repository;

    public List<Post> getAll() {
        return (List<Post>) repository.findAll();
    }

    public Post getById(Long id) {
        Optional<Post> post = repository.findById(id);
        return post.orElse(null);
    }

    public Post create(Post post) {
        return repository.save(post);
    }

    public Post update(Long id, Post post) {
        Optional<Post> existingPost = repository.findById(id);
        if (existingPost.isPresent()) {
            Post updatedPost = existingPost.get();
            updatedPost.setTitle(post.getTitle());
            return repository.save(updatedPost);
        } else {
            return null;
        }
    }

    public boolean delete(Long id) {
        try {
            repository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}