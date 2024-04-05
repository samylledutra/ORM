package com.example.Biblioteca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.Biblioteca.domain.PostComment;
import com.example.Biblioteca.service.PostCommentService;


@RestController
@RequestMapping("/library")
public class PostCommentController {

    @Autowired
    PostCommentService service;

    @GetMapping("/postcomment/{id}")
    public ResponseEntity<PostComment> getPostCommentById(@PathVariable("id") Long id) {
        PostComment postComment = service.getById(id);
        if (postComment != null) {
            return ResponseEntity.ok(postComment);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/postcomment/create") 
    public PostComment createPostComment(@RequestBody PostComment postComment) {
        return service.create(postComment);
    }

    @DeleteMapping("/postcomment/{id}")
    public boolean deletePostComment(@PathVariable("id") Long id) {
        return service.delete(id);
    }

    @PostMapping("/addComment")
    public PostComment addComment(@RequestBody PostComment comment) {
        return service.addComment(comment);
    }

    @GetMapping("/getAllPostComments")
    public List<PostComment> getAllPostComments() {
        return service.getAll();
    }
}