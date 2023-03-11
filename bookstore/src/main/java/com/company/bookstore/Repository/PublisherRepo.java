package com.company.bookstore.Repository;

import com.company.bookstore.Model.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PublisherRepo extends JpaRepository<Publisher, Integer> {
    List<Publisher> findByPublisherId(Integer PublisherId);
}
