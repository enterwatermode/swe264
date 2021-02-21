package com.uci.edu.bookbackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uci.edu.bookbackend.repository.BookContentRepository;
import com.uci.edu.bookbackend.model.*;
import java.util.*;


@RestController
@RequestMapping("/data/")
public class BookContentController {

    @Autowired
    private BookContentRepository bcr;

    @GetMapping("/content")
    public List<BookContent> getAllRecords() {
        return bcr.findAll();
    }

    @PostMapping("/content")
    public BookContent createRecord(@RequestBody BookContent record) {
        return bcr.save(record);
    }

}
