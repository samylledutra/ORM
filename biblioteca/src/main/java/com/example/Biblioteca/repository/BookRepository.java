package com.example.Biblioteca.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.Biblioteca.domain.Book;

public interface BookRepository extends CrudRepository<Book,Long> {
    
}