package com.example.Biblioteca.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.Biblioteca.domain.PostComment;

public interface PostCommentRepository extends CrudRepository<PostComment,Long>{
    
}