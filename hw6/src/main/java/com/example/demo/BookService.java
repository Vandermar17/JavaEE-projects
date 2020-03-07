package com.example.demo;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final EntityManager entityManager;


    @Transactional
    public Book createBook(String name, String isbn, String author) {
        Book book = new Book();
        book.setName(name);
        book.setIsbn(isbn);
        book.setAuthor(author);
        return entityManager.merge(book);
    }

    public List<Book> findAll(){
        return entityManager.createNamedQuery(Book.FIND_ALL,Book.class).getResultList();
    }

    public Book findByID(Integer id){
        return entityManager.createNamedQuery(Book.FIND_BY_ID,Book.class)
                .setParameter("id",id).
                        getSingleResult();
    }

}
