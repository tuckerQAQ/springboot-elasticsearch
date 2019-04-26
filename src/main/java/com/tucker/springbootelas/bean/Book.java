package com.tucker.springbootelas.bean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.elasticsearch.annotations.Document;

@Getter
@Setter
@ToString
@Document(indexName = "tucker",type = "book")
public class Book {
    private Integer id;
    private String author;
    private String bookName;
}
