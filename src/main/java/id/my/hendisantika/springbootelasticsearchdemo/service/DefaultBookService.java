package id.my.hendisantika.springbootelasticsearchdemo.service;

import id.my.hendisantika.springbootelasticsearchdemo.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.elasticsearch.client.elc.ElasticsearchTemplate;
import org.springframework.stereotype.Service;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-elasticsearch-demo
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 3/16/24
 * Time: 09:10
 * To change this template use File | Settings | File Templates.
 */
@Service
@RequiredArgsConstructor
public class DefaultBookService implements BookService {

    private final BookRepository bookRepository;

    private final ElasticsearchTemplate elasticsearchTemplate;
}
