package id.my.hendisantika.springbootelasticsearchdemo.dto;

import id.my.hendisantika.springbootelasticsearchdemo.metadata.PublicationYear;
import id.my.hendisantika.springbootelasticsearchdemo.model.Book;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-elasticsearch-demo
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 3/16/24
 * Time: 09:18
 * To change this template use File | Settings | File Templates.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDto {
    @NotBlank
    private String title;

    @Positive
    @PublicationYear
    private Integer publicationYear;

    @NotBlank
    private String authorName;

    @NotBlank
    private String isbn;

    public static Book transform(BookDto bookDto) {
        Book book = new Book();
        book.setTitle(bookDto.title);
        book.setPublicationYear(bookDto.publicationYear);
        book.setAuthorName(bookDto.authorName);
        book.setIsbn(bookDto.isbn);
        return book;
    }
}
