package com.example.demo;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.es.dao.BookRepository;
import com.example.demo.es.entity.Book;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.IndexOperations;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class TestEs {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private ElasticsearchRestTemplate elasticsearchRestTemplate;

    @Test
    public void testSave() {
        Book book = new Book();
        book.setAuthor("elastic");
        book.setBookName("elasticsearch 开发文档");
        bookRepository.save(book);
    }

    @Test
    public void testSaveBatch() {
        Book book = new Book();
        book.setAuthor("都开始");
        book.setBookName("java编程指南");

        Book book1 = new Book();
        book1.setAuthor("个人赛");
        book1.setBookName("php编程指南");

        Book book2 = new Book();
        book2.setAuthor("寄快递");
        book2.setBookName("数据结构");

        List<Book> list = new ArrayList<>();
        list.add(book);
        list.add(book1);
        list.add(book2);
        bookRepository.saveAll(list);
    }

    @Test
    public void testSelect() {
        Optional<Book> book = bookRepository.findById("iiUbQXkB0L2NxWC-_PlT");
        log.info("book===== " + JSONObject.toJSONString(book));

        List<Book> books = bookRepository.findByAuthor("寄快递");
        log.info("books===== " + JSONObject.toJSONString(books));

        List<Book> books1 = bookRepository.findByBookName("java");
        log.info("books1===== " + JSONObject.toJSONString(books1));

        List<Book> books2 = bookRepository.findByAuthorAndBookName("elastic","elastic");
        log.info("books2===== " + JSONObject.toJSONString(books2));

        List<Book> books3 = bookRepository.findByAuthorOrBookName("elastic","elastic");
        log.info("books3===== " + JSONObject.toJSONString(books3));
    }

    @Test
    public void testCreate() {
        IndexOperations indexOps = this.elasticsearchRestTemplate.indexOps(Book.class);
        Boolean imb = indexOps.putMapping();
    }
}
