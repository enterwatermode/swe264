package com.uci.edu.bookbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uci.edu.bookbackend.model.*;

@Repository
public interface BookContentRepository extends JpaRepository<BookContent, Long>{
}
