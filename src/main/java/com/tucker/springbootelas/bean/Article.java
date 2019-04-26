package com.tucker.springbootelas.bean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Article {
    private Integer id;
    private String author;
    private String title;
    private String content;
}
