package com.example.Library_Management.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Library_Management.Entity.Book;

public interface BookRepository extends
JpaRepository<Book,Long>
{

List<Book> findByTitleContainingIgnoreCase(String title);
List<Book> findByAuthorContainingIgnoreCase(String title);




}
