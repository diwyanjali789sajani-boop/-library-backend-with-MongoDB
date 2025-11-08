package com.example.library_backend.repository;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.library_backend.model.Book;

public interface BookRepository extends MongoRepository<Book, String> {
    List<Book> findByPublicationYear(Integer publicationYear);
    // custom derived delete
    Long deleteByPublicationYear(Integer publicationYear);
}

