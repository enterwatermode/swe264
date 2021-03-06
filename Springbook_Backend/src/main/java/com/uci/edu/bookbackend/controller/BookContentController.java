package com.uci.edu.bookbackend.controller;

import com.uci.edu.bookbackend.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.uci.edu.bookbackend.repository.BookContentRepository;
import com.uci.edu.bookbackend.model.*;
import java.util.*;

@CrossOrigin(origins = "http://54.183.80.30:3000")
@RestController
@RequestMapping("/data/")
public class BookContentController {

    @Autowired
    private BookContentRepository bcr;

    //all the record
    @GetMapping("/content")
    public List<BookContent> getAllRecords() {
        return bcr.findAll();
    }

    @PostMapping("/content")
    public BookContent createRecord(@RequestBody BookContent record) {
        return bcr.save(record);
    }

    //get book by book's name
    @GetMapping("/content/{name}")
    public List<BookContent> getBookByName(@PathVariable String name) {
        return bcr.getBookContentByBookname(name);
    }

    //get book by an id
    @GetMapping("/content/get/{id}")
    public Optional<BookContent> getBookById(@PathVariable Long id) {
        return bcr.findById(id);
    }

    //get all the books' name
    @GetMapping("/names")
    public List<String> getAllBooksName() {
        return bcr.getAllBooksName();
    }

    @GetMapping("/namesId")
    public List<Object> getAllBooksNameWithId() {
        return bcr.getAllBooksNameWithId();
    }

    //Delete a specific book in the database
    @DeleteMapping("/content/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteBook(@PathVariable Long id) {
        BookContent book = bcr.findById(id).orElseThrow(() -> new ResourceNotFoundException("Book not exist:" + id));
        bcr.delete(book);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
