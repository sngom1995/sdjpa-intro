package guru.springframework.sdjpaintro.bootstrap;

import guru.springframework.sdjpaintro.domain.Book;
import guru.springframework.sdjpaintro.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile({"local", "default"})
public class DataInitialization implements CommandLineRunner {
    private final BookRepository bookRepository;

    public DataInitialization(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Book book1 = new Book(1L, "Spring Jpa","123121","SAMBA");
        bookRepository.save(book1);
        Book book2 = new Book(2L, "Spring Framework","123517", "SAMBA");
        bookRepository.save(book2);

        bookRepository.findAll().forEach(book -> {
            System.out.println("id: " + book.getId());
            System.out.println("Title:"+book.getTitle());
        });
    }
}
