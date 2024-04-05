package com.example.Biblioteca.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.Biblioteca.domain.Library;

public interface LibraryRepository extends CrudRepository<Library,Long> {
    
}