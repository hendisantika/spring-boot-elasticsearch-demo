package id.my.hendisantika.springbootelasticsearchdemo;

import id.my.hendisantika.springbootelasticsearchdemo.exception.DuplicateIsbnException;
import id.my.hendisantika.springbootelasticsearchdemo.model.Book;
import id.my.hendisantika.springbootelasticsearchdemo.service.BookService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.client.elc.ElasticsearchTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.testcontainers.elasticsearch.ElasticsearchContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@Testcontainers
@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SpringBootElasticsearchDemoApplicationTests {

    @Container
    private static final ElasticsearchContainer elasticsearchContainer = new BookElasticsearchContainer();
    @Autowired
    private BookService bookService;
    @Autowired
    private ElasticsearchTemplate template;

    @BeforeAll
    static void setUp() {
        elasticsearchContainer.start();
    }

    @BeforeEach
    void testIsContainerRunning() {
        assertTrue(elasticsearchContainer.isRunning());
        recreateIndex();
    }

    @Test
    void testGetBookByIsbn() throws DuplicateIsbnException {
        bookService.create(createBook("12 rules for life", "Jordan Peterson", 2018, "978-0345816023"));
        Optional<Book> result = bookService.getByIsbn("978-0345816023");
        assertTrue(result.isPresent());
        Book createdBook = result.get();
        assertNotNull(createdBook);
        assertEquals("12 rules for life", createdBook.getTitle());
        assertEquals("Jordan Peterson", createdBook.getAuthorName());
        assertEquals(2018, createdBook.getPublicationYear());
        assertEquals("978-0345816023", createdBook.getIsbn());
    }

    @Test
    void testGetAllBooks() throws DuplicateIsbnException {
        bookService.create(createBook("12 rules for life", "Jordan Peterson", 2018, "978-0345816023"));
        bookService.create(createBook("The Cathedral and the Bazaar", "Eric Raymond", 1999, "9780596106386"));
        List<Book> books = bookService.getAll();

        assertNotNull(books);
        assertEquals(2, books.size());
    }

    @Test
    void testFindByAuthor() throws DuplicateIsbnException {
        bookService.create(createBook("12 rules for life", "Jordan Peterson", 2018, "978-0345816023"));
        bookService.create(createBook("Maps of Meaning", "Jordan Peterson", 1999, "9781280407253"));

        List<Book> books = bookService.findByAuthor("Jordan Peterson");

        assertNotNull(books);
        assertEquals(2, books.size());
    }

    @Test
    void testFindByTitleAndAuthor() throws DuplicateIsbnException {
        bookService.create(createBook("12 rules for life", "Jordan Peterson", 2018, "978-0345816023"));
        bookService.create(createBook("Rules or not rules?", "Jordan Miller", 2010, "978128000000"));
        bookService.create(createBook("Poor economy", "Jordan Miller", 2006, "9781280789000"));
        bookService.create(createBook("The Cathedral and the Bazaar", "Eric Raymond", 1999, "9780596106386"));

        List<Book> books = bookService.findByTitleAndAuthor("rules", "jordan");

        assertNotNull(books);
        assertEquals(2, books.size());
    }
}
