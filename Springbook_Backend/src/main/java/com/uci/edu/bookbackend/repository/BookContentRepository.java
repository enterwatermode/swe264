package com.uci.edu.bookbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.uci.edu.bookbackend.model.*;

import java.util.List;

@Repository
public interface BookContentRepository extends JpaRepository<BookContent, Long>{

    @Query(value = "SELECT * FROM bookcontent WHERE bookname = ?1", nativeQuery = true)
    public List<BookContent> getBookContentByBookname(String bookname);

    @Query(value = "SELECT bookname FROM bookcontent", nativeQuery = true)
    public List<String> getAllBooksName();
}
