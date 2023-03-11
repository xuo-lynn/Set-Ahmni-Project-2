package com.company.bookstore.repository;

import com.company.bookstore.Model.Book;
import com.company.bookstore.Model.Publisher;
import com.company.bookstore.Repository.BookRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class BookRepoTest {
    @Autowired
    private BookRepo bookRepo;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void testFindByAuthorId() {
        // Create a publisher and save it to the database
        Publisher publisher = new Publisher();
        publisher.setFirstName("John");
        publisher.setLastName("Doe");
        publisher.setAddress1("123 Main St");
        publisher.setCity("New York");
        publisher.setState("NY");
        publisher.setPostalCode(10001);
        publisher.setCountry("USA");
        publisher.setEmail("johndoe@example.com");
        entityManager.persist(publisher);

        // Create a book and set its author to the publisher created above
        Book book = new Book();
        book.setIsbn("978-3-16-148410-0");
        book.setPublishDate(LocalDate.of(2022, 3, 1));
        book.setAuthor(publisher);
        book.setTitle("Java for Beginners");
        book.setPublisher(publisher);
        book.setPrice(BigDecimal.valueOf(19.99));
        entityManager.persist(book);

        // Create another book with a different author
        Publisher anotherPublisher = new Publisher();
        anotherPublisher.setFirstName("Jane");
        anotherPublisher.setLastName("Smith");
        anotherPublisher.setAddress1("456 Main St");
        anotherPublisher.setCity("Los Angeles");
        anotherPublisher.setState("CA");
        anotherPublisher.setPostalCode(90001);
        anotherPublisher.setCountry("USA");
        anotherPublisher.setEmail("janesmith@example.com");
        entityManager.persist(anotherPublisher);

        Book anotherBook = new Book();
        anotherBook.setIsbn("978-3-16-148410-1");
        anotherBook.setPublishDate(LocalDate.of(2022, 3, 2));
        anotherBook.setAuthor(anotherPublisher);
        anotherBook.setTitle("Python for Beginners");
        anotherBook.setPublisher(anotherPublisher);
        anotherBook.setPrice(BigDecimal.valueOf(24.99));
        entityManager.persist(anotherBook);

        // Call the findByAuthorId method and check that it returns the correct book
        List<Book> books = bookRepo.findByAuthorId(publisher.getId());
        assertThat(books.size()).isEqualTo(1);
        assertThat(books.get(0)).isEqualTo(book);
    }
}
