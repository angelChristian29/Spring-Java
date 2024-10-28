package com.example.Six_Java.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Six_Java.Models.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer>{

}
