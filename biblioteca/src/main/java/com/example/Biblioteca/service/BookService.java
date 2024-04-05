package com.example.Biblioteca.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Biblioteca.domain.Book;
import com.example.Biblioteca.repository.BookRepository;


@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    public List<Book> getAll() {
        try {
            List<Book> items = new ArrayList<Book>();

            bookRepository.findAll().forEach(items::add);
            return items;
        } catch (Exception e) {
            return null;
        }
    }

    public Book getById(Long id) {
        Optional<Book> item = bookRepository.findById(id);
        if (item.isPresent()) {
            return item.get();
        }
        return null;
    }

    public Book create(Book item) {
        return bookRepository.save(item);
    }

    public Book update(Long id, Book item) {
        Optional<Book> existingItemOptional = bookRepository.findById(id);

        if (existingItemOptional.isPresent()) {
            Book existingItem = existingItemOptional.get();
            existingItem.setNome(item.getNome());
            return bookRepository.save(existingItem);
        } else {
            return null;
        }
    }

    public boolean delete(Long id) {
        try {
            bookRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}