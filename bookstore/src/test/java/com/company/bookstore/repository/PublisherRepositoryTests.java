package com.company.bookstore.repository;

import com.company.bookstore.Model.Publisher;
import com.company.bookstore.Repository.PublisherRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PublisherRepositoryTests {
    @Autowired
    PublisherRepository publisherRepo;


    @Before
    public void setUp() throws Exception {
        publisherRepo.deleteAll();
    }

    @Test
    public void addPublisher() {
        //Arrange...
        Publisher publisher = new Publisher();
        publisher.setName("Joe Smith");


        //Act...
        publisher = publisherRepo.save(publisher);

        //Assert...
        Optional<Publisher> publisher1 = publisherRepo.findById(publisher.getId());

        assertEquals(publisher1.get(), publisher);
    }
    @Test
    public void getPublisher() {
        //Arrange...
        Publisher publisher = new Publisher();
        publisher.setName("Joe Smith");


        Publisher publisher2 = new Publisher();
        publisher2.setName("Bob Marley");

        publisherRepo.save(publisher2);
        //Act...
        publisher = publisherRepo.save(publisher);

        //Assert...
        Optional<Publisher> publisher1 = publisherRepo.findById(publisher.getId());

        assertEquals(publisher1.get(), publisher);
    }
    @Test
    public void getPublishers() {
        //Arrange...

        //Act...
        Publisher publisher = new Publisher();
        publisher.setName("Joe Smith");
        publisher.setState("KS");
        publisher.setStreet("Meriden");
        publisher.setCity("Topeka");
        publisher.setPostalCode(66617);

        publisherRepo.save(publisher);

        Publisher publisher2 = new Publisher();
        publisher2.setName("Bob Marley");
        publisher.setState("KS");
        publisher.setStreet("Meriden");
        publisher.setCity("Topeka");

        publisherRepo.save(publisher2);

        List<Publisher> publisherList = publisherRepo.findAll();

        //Assert...
        assertEquals(2, publisherList.size());
    }

    @Test
    public void updatePublisher() {
        //Arrange...
        Publisher publisher = new Publisher();
        publisher.setName("Joe Smith");

        publisherRepo.save(publisher);

        //Act...
        publisher.setName("UPDATED");

        publisherRepo.save(publisher);

        //Assert...
        Optional<Publisher> publisher1 = publisherRepo.findById(publisher.getId());

        assertEquals(publisher1.get(), publisher);
    }

    @Test
    public void deletePublisher() {
        //Arrange...
        Publisher publisher = new Publisher();
        publisher.setName("Joe Smith");

        publisherRepo.save(publisher);

        //Act...
        publisherRepo.deleteById(publisher.getId());

        //Assert...
        Optional<Publisher> publisher1 = publisherRepo.findById(publisher.getId());
        assertFalse(publisher1.isPresent());
    }
}
