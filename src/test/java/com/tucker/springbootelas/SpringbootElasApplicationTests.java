package com.tucker.springbootelas;

import com.tucker.springbootelas.bean.Article;
import com.tucker.springbootelas.bean.Book;
import com.tucker.springbootelas.repository.BookRepository;
import io.searchbox.client.JestClient;
import io.searchbox.client.JestResult;
import io.searchbox.core.DocumentResult;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;
import io.searchbox.indices.CreateIndex;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootElasApplicationTests {

    @Autowired
    JestClient jestClient;
    @Autowired
    BookRepository bookRepository;

    @Test
    public  void test02(){
        Book book = new Book();
        bookRepository.index(book);
    }

    @Test
    public void contextLoads() {
        Article article = new Article();
        article.setId(1);
        article.setAuthor("张三");
        article.setContent("hello");
        article.setTitle("消息");

        Index index = new Index.Builder(article).index("tucker").type("news").build();

        try {
            JestResult jr = jestClient.execute(index);
            System.out.println(jr.isSucceeded());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void search() {
        String json = "{\"query\" : {\"bool\" : {\"must\": [{\"match_all\" : {}}]}},\"from\" : 0,\"size\" : 1}";
        Search search = new Search.Builder(json).addIndex("tucker").addType("news").build();
        try {
            SearchResult result = jestClient.execute(search);
            System.out.println(result.getMaxScore());
            System.out.println(result.getJsonString());
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
