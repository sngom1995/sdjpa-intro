package guru.springframework.sdjpaintro.controller;

import guru.springframework.sdjpaintro.repository.BookRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/books")
public class BookController {
    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping
    public ResponseEntity<?> getAllBooks() {
        return ResponseEntity.ok(bookRepository.findAll());
    }
}