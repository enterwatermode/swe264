package com.uci.edu.bookbackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.uci.edu.bookbackend.repository.BookContentRepository;
import com.uci.edu.bookbackend.model.*;
import java.util.*;

@CrossOrigin(origins = "http://localhost:3000")
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

    //get all the books' name
    @GetMapping("/names")
    public List<String> getAllBooksName() {
        return bcr.getAllBooksName();
    }
}
