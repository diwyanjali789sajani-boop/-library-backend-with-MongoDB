package com.example.library_backend.service;
import java.util.List;
import com.example.library_backend.model.Book;
import java.util.Optional;

public interface BookSevice {
    Book addBook(Book book);
    List<Book> getAllBooks();
    Optional<Book> getBookById(String id);
    Book updateBook(String id, Book updated);
    void deleteBookById(String id);
    List<Book> findByPublicationYear(Integer year);
    Optional<String> getGenreByBookId(String id);
    Long deleteAllByPublicationYear(Integer year);
}
