package id.my.hendisantika.springbootelasticsearchdemo.exception;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-elasticsearch-demo
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 3/16/24
 * Time: 09:08
 * To change this template use File | Settings | File Templates.
 */
public class BookNotFoundException extends Exception {

    public BookNotFoundException(String message) {
        super(message);
    }
}
