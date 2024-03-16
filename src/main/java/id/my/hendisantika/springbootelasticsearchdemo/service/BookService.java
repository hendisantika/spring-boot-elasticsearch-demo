package id.my.hendisantika.springbootelasticsearchdemo.service;

import id.my.hendisantika.springbootelasticsearchdemo.exception.BookNotFoundException;
import id.my.hendisantika.springbootelasticsearchdemo.exception.DuplicateIsbnException;
import id.my.hendisantika.springbootelasticsearchdemo.model.Book;

import java.util.List;
import java.util.Optional;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-elasticsearch-demo
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 3/16/24
 * Time: 09:09
 * To change this template use File | Settings | File Templates.
 */
public interface BookService {

    Optional<Book> getByIsbn(String isbn);

    List<Book> getAll();

    List<Book> findByAuthor(String authorName);

    List<Book> findByTitleAndAuthor(String title, String author);

    Book create(Book book) throws DuplicateIsbnException;

    void deleteById(String id);

    Book update(String id, Book book) throws BookNotFoundException;
}
