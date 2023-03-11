package com.company.bookstore.Controller;


import com.company.bookstore.Model.Publisher;
import com.company.bookstore.Repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class GraphController {
    @Autowired
    PublisherRepository publisherRepository;

    @QueryMapping
    public Optional<Publisher> findPublisherById(@Argument int id) {
        return publisherRepository.findById(id);
    }


}
