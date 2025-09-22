package com.example.Library_Management.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.Library_Management.Entity.Book;
import com.example.Library_Management.Repository.BookRepository;

@Service
public class BookService {

	private BookRepository repo;

	public BookService(BookRepository repo) {
		this.repo=repo;
	}

	public List<Book> getAllProducts() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	public Book getBookById(long id) {
		// TODO Auto-generated method stub
		return repo.findById(id).orElseThrow(()->new RuntimeException());
	}

	public List<Book> search(String q) {
		// TODO Auto-generated method stub
		return repo.findByTitleContainingIgnoreCase(q);
	}

	public Book addBook(Book b) {
		// TODO Auto-generated method stub
		return repo.save(b);
	}

	public Book updateBook(long id, Book b) {
	    Book bk = repo.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));

	    // Update fields from request body
	    bk.setTitle(b.getTitle());
	    bk.setAuthor(b.getAuthor());
	    bk.setCategory(b.getCategory());
	    bk.setTotalCopies(b.getTotalCopies());
	    bk.setAvailableCopies(b.getAvailableCopies());

	    return repo.save(bk);
	}


	public void deleteBook(long id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
	}


}
