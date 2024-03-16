package id.my.hendisantika.springbootelasticsearchdemo.controller;

import id.my.hendisantika.springbootelasticsearchdemo.model.Book;
import id.my.hendisantika.springbootelasticsearchdemo.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-elasticsearch-demo
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 3/16/24
 * Time: 09:15
 * To change this template use File | Settings | File Templates.
 */
@RestController
@RequestMapping("/v1/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAll();
    }

}
