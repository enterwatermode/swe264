package com.uci.edu.bookbackend.controller;

import com.uci.edu.bookbackend.model.ReadingTime;
import com.uci.edu.bookbackend.repository.ReadingTimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://54.176.130.211:3000")
@RestController
@RequestMapping("/time/")
public class ReadingTimeController {
    @Autowired
    private ReadingTimeRepository rtr;

    @PostMapping("/{time}")
    public ReadingTime createTime(@PathVariable String time) {
        ReadingTime readingTime = new ReadingTime(time);
        return rtr.save(readingTime);
    }

    @GetMapping("/find/all")
    public List<ReadingTime> getAllRecords() {
        return rtr.findAll();
    }
}
