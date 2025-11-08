package com.example.library_backend.controller;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;

import com.example.library_backend.model.Book;
import com.example.library_backend.service.BookSevice;

import java.util.List;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
public class BookController {
    private final BookSevice bookService;

    @PostMapping
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        return ResponseEntity.ok(bookService.addBook(book));
    }

    @GetMapping
    public ResponseEntity<List<Book>> getAll() {
        return ResponseEntity.ok(bookService.getAllBooks());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getById(@PathVariable String id) {
        return bookService.getBookById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> update(@PathVariable String id, @RequestBody Book book) {
        try {
            return ResponseEntity.ok(bookService.updateBook(id, book));
        } catch (RuntimeException ex) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        bookService.deleteBookById(id);
        return ResponseEntity.noContent().build();
    }

    // Custom queries
    @GetMapping("/year/{year}")
    public ResponseEntity<List<Book>> getByYear(@PathVariable Integer year) {
        return ResponseEntity.ok(bookService.findByPublicationYear(year));
    }

    @GetMapping("/{id}/genre")
    public ResponseEntity<String> getGenre(@PathVariable String id) {
        return bookService.getGenreByBookId(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/year/{year}")
    public ResponseEntity<String> deleteByYear(@PathVariable Integer year) {
        Long deleted = bookService.deleteAllByPublicationYear(year);
        return ResponseEntity.ok(deleted + " book(s) deleted for year " + year);
    }
}

