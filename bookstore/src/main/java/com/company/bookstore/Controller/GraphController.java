package com.company.bookstore.Controller;//package com.company.bookstore.Controller;
//
//import com.company.bookstore.Model.Publisher;
//import com.company.bookstore.Repository.PublisherRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.graphql.data.method.annotation.Argument;
//import org.springframework.graphql.data.method.annotation.MutationMapping;
//import org.springframework.graphql.data.method.annotation.QueryMapping;
//import org.springframework.stereotype.Controller;
//
//import java.util.List;
//
//@Controller
//public class GraphController {
//    @Autowired
//    PublisherRepository publisherRepository;
//
//    @QueryMapping
//    public List<Publisher> publishers() {
//        return  publisherRepository.getPublishers();
//    }
//
//    @QueryMapping
//    public Publisher findPublisherById(@Argument String id) {
//        return publisherRepository.getPublisherById(id);
//    }
//
//    @MutationMapping
//    public Publisher addPublisher(
//            @Argument String id,
//            @Argument String make,
//            @Argument String model,
//            @Argument int year) {
//        return publisherRepository.addPublisher(id, make, model, year);
//    }
//
//    @MutationMapping
//    public Publisher updatePublisher(
//            @Argument String id,
//            @Argument String make,
//            @Argument String model,
//            @Argument int year) {
//        Publisher updatedPublisher = new Publisher(id, make, model, year);
//        return publisherRepository.updatePublisher(updatedPublisher);
//    }
//
//    @MutationMapping
//    public boolean deletePublisherById(@Argument String id) {
//        return publisherRepository.deletePublisherById(id);
//    }
//}
