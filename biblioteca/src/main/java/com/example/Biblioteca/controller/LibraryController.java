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

import com.example.Biblioteca.domain.Library;
import com.example.Biblioteca.service.LibraryService;

@RestController
@RequestMapping("/library")
class LibraryController {

    @Autowired
    LibraryService service;

    @GetMapping
    public List<Library> getAll() {
        List<Library> items = service.getAll();
        return items;
    }

    @GetMapping("/{id}")
    public Library getById(@PathVariable("id") Long id) {
        return service.getById(id);
    }

    @PostMapping("/create") 
    public Library createLibrary(@RequestBody Library item) {
        Library categoria = service.create(item);
        return categoria;
    }

    @PutMapping("/{id}")
    public Library update(@PathVariable("id") Long id, @RequestBody Library item) {
        return service.update(id, item);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable("id") Long id) {
        return service.delete(id);
    }

}