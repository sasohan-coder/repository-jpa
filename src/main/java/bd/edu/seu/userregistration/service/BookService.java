package bd.edu.seu.userregistration.service;

import bd.edu.seu.userregistration.model.Book;
import bd.edu.seu.userregistration.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void save(Book book) {
        bookRepository.save(book);
        IO.println("Saved book");
    }

    public void delete(int id) {
        bookRepository.deleteById(id);
        IO.println("Deleted book");
    }

    public Book findById(int id) {
//        Optional<Book> optional = bookRepository.findById(id);
//        if (optional.isPresent()) {
//            return optional.get();
//        } else {
//            IO.println("No book with id " + id);
//            return null;
//        }
        return bookRepository.findById(id).orElse(null);
    }

    public List<Book> findAll() {
        return bookRepository.findAll();
    }
}
