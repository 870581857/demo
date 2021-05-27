package com.example.demo.es.dao;

import com.example.demo.es.entity.Book;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface BookRepository extends ElasticsearchRepository<Book, String> {
    List<Book> findByAuthor(String author);

    List<Book> findByBookName(String bookName);

    List<Book> findByAuthorAndBookName(String author, String bookName);

    List<Book> findByAuthorOrBookName(String author, String bookName);
}