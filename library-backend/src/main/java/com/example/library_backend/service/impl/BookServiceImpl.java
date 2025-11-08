package com.example.library_backend.service.impl;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import com.example.library_backend.repository.BookRepository;
import com.example.library_backend.model.Book;
import com.example.library_backend.service.BookSevice;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookSevice {
    private final BookRepository bookRepository;

    @Override
    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> getBookById(String id) {
        return bookRepository.findById(id);
    }

    @Override
    public Book updateBook(String id, Book updated) {
        return bookRepository.findById(id).map(existing -> {
            existing.setTitle(updated.getTitle());
            existing.setAuthor(updated.getAuthor());
            existing.setPublicationYear(updated.getPublicationYear());
            existing.setGenre(updated.getGenre());
            existing.setIsbn(updated.getIsbn());
            return bookRepository.save(existing);
        }).orElseThrow(() -> new RuntimeException("Book not found with id: " + id));
    }

    @Override
    public void deleteBookById(String id) {
        bookRepository.deleteById(id);
    }

    @Override
    public List<Book> findByPublicationYear(Integer year) {
        return bookRepository.findByPublicationYear(year);
    }

    @Override
    public Optional<String> getGenreByBookId(String id) {
        return bookRepository.findById(id).map(Book::getGenre);
    }

    @Override
    public Long deleteAllByPublicationYear(Integer year) {
        return bookRepository.deleteByPublicationYear(year);
    }
}

