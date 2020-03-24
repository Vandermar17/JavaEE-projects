package com.example.demo;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book,Integer> {
    Book findBookByIsbn(String isbn);
    Book findBookByName(String name);
    List<Book> findAllByIsbn(String isbn);
    List<Book> findAllByName(String name);
}
