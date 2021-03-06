package com.uci.edu.bookbackend.repository;

import com.uci.edu.bookbackend.model.ReadingTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReadingTimeRepository extends JpaRepository <ReadingTime,  Long> {
}
