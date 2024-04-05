package com.example.Biblioteca.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.Biblioteca.domain.Post;

public interface PostRepository extends CrudRepository<Post,Long>{
    
}