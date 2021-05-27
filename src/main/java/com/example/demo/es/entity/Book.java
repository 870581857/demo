package com.example.demo.es.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName = "atguigutest")
@Data
public class Book {
    @Id
    private String id;
    @Field(type = FieldType.Keyword)
    private String bookName;
    @Field(type = FieldType.Keyword)
    private String author;
}
