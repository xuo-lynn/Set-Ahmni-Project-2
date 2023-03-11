package com.company.bookstore.repository;

import com.company.bookstore.Model.Publisher;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PublisherRepoistoryTests {

    @Test
    public void testPublisherEqualsAndHashCode() {
        Publisher publisher1 = new Publisher();
        publisher1.setId(1);
        publisher1.setFirstName("John");
        publisher1.setLastName("Doe");
        publisher1.setAddress1("123 Main St");
        publisher1.setCity("Anytown");
        publisher1.setState("CA");
        publisher1.setPostalCode(12345);
        publisher1.setCountry("USA");
        publisher1.setEmail("john.doe@example.com");

        Publisher publisher2 = new Publisher();
        publisher2.setId(1);
        publisher2.setFirstName("John");
        publisher2.setLastName("Doe");
        publisher2.setAddress1("123 Main St");
        publisher2.setCity("Anytown");
        publisher2.setState("CA");
        publisher2.setPostalCode(12345);
        publisher2.setCountry("USA");
        publisher2.setEmail("john.doe@example.com");

        // Test equals
        Assertions.assertEquals(publisher1, publisher2);

        // Test hashCode
        Assertions.assertEquals(publisher1.hashCode(), publisher2.hashCode());
    }

}

