package id.my.hendisantika.springbootelasticsearchdemo.repository;

import id.my.hendisantika.springbootelasticsearchdemo.model.Book;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-elasticsearch-demo
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 3/16/24
 * Time: 09:07
 * To change this template use File | Settings | File Templates.
 */
@Repository
public interface BookRepository extends ElasticsearchRepository<Book, String> {
}
