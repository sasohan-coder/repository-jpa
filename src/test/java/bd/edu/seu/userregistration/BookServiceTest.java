package bd.edu.seu.userregistration;

import bd.edu.seu.userregistration.model.Book;
import bd.edu.seu.userregistration.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class BookServiceTest {

    @Autowired
    BookService bookService;

    @Test
    public void saveTest() {
        Book book = new Book();
        book.setId(2);
        book.setTitle("Advanced Java Book");
        book.setAuthor("Azmainur");
        bookService.save(book);
    }

    @Test
    public void getBookTest() {
        Book book = bookService.findById(2);
        IO.println(book.getId() +  " " + book.getTitle() + " " + book.getAuthor());
    }

    @Test
    public void getAllBookTest() {
        List<Book> bookList = bookService.findAll();
        for (Book book : bookList) {
            IO.println(book.getId() + " " + book.getTitle() + " " + book.getAuthor());
        }
    }
}
