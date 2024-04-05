package com.example.Biblioteca.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Biblioteca.domain.Library;
import com.example.Biblioteca.repository.LibraryRepository;


@Service
public class LibraryService {

   
    @Autowired
    LibraryRepository repository;

    public List<Library> getAll() {
        try {
            List<Library> items = new ArrayList<Library>();

           
            repository.findAll().forEach(items::add);
            return items;
        } catch (Exception e) {
            return null;
        }
    }

    public Library getById(Long id) {
        Optional<Library> Library = repository.findById(id);
        if (Library.isPresent()) {
            return Library.get();
        }
        return null;
    }

    public Library create(Library Library) {
        return repository.save(Library);
    }

    public Library update(Long id, Library item) {
        Optional<Library> existingItemOptional = repository.findById(id);

        if (existingItemOptional.isPresent()) {
            Library existingItem = existingItemOptional.get();
            existingItem.setNome(item.getNome());
            return repository.save(existingItem);
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