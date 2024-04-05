package com.example.Biblioteca.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Biblioteca.domain.PostComment;
import com.example.Biblioteca.repository.PostCommentRepository;

@Service
public class PostCommentService {

    @Autowired
    PostCommentRepository repository;

    public List<PostComment> getAll() {
        return (List<PostComment>) repository.findAll();
    }

    public PostComment getById(Long id) {
        Optional<PostComment> postComment = repository.findById(id);
        return postComment.orElse(null);
    }

    public PostComment create(PostComment postComment) {
        return repository.save(postComment);
    }

    public PostComment update(Long id, PostComment postComment) {
        Optional<PostComment> existingPostComment = repository.findById(id);
        if (existingPostComment.isPresent()) {
            PostComment updatedPostComment = existingPostComment.get();
            updatedPostComment.setReview(postComment.getReview());
            return repository.save(updatedPostComment);
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

    public PostComment addComment(PostComment comment) {
        return repository.save(comment);
    }
}