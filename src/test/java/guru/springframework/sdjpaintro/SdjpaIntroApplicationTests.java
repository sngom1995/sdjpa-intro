package guru.springframework.sdjpaintro;

import guru.springframework.sdjpaintro.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class SdjpaIntroApplicationTests {


    @Autowired
    BookRepository bookRepository;

    @Test
    void bookRepositoryTest() {
        Long count = bookRepository.count();
        assertThat(count).isEqualTo(2);
    }

    @Test
    void contextLoads() {
    }

}
