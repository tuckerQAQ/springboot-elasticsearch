package com.tucker.springbootelas.repository;

import com.tucker.springbootelas.bean.Book;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface BookRepository extends ElasticsearchRepository<Book,Integer> {

}
