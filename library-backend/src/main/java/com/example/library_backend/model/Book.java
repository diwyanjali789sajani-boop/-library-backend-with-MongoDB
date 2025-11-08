package com.example.library_backend.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.*;

@Document(collection = "books")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Book {
    @Id
    private String id;        // MongoDB ObjectId stored as String
    private String title;
    private String author;
    private Integer publicationYear;
    private String genre;
    private String isbn;     // optional
}
