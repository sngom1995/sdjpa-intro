package guru.springframework.sdjpaintro;


import guru.springframework.sdjpaintro.domain.Book;
import guru.springframework.sdjpaintro.repository.BookRepository;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DataJpaTest
@ComponentScan(basePackages = {"guru.springframework.sdjpaintro.bootstrap"})
public class SpringBootJpaSliceTest {

    @Autowired
    BookRepository bookRepository;


    @Rollback(value = false)
    @Order(1)
    @Test
    void bookRepositoryTestJpa() {
        long countBefore = bookRepository.count();
        assertThat(countBefore).isEqualTo(2);

        bookRepository.save(new Book(3L,"MyBook", "124326","123"));

        long countAfter = bookRepository.count();
        assertThat(countBefore).isLessThan(countAfter);
    }

    @Order(2)
    @Test
    void testTransactionJpa() {
        long countBefore = bookRepository.count();
        assertThat(countBefore).isEqualTo(3);
    }
}
