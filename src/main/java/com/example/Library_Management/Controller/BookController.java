package com.example.Library_Management.Controller;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Library_Management.Entity.Book;
import com.example.Library_Management.Service.BookService;

@RestController
@RequestMapping("/api/books")
public class BookController {

	private final BookService ser;
	public BookController(BookService ser) {
		this.ser=ser;
	}


	@GetMapping
	public List<Book> getAllProducts(){
		return ser.getAllProducts();
	}

	@GetMapping("/{id}")
	public Book getBook(@PathVariable long id) {
		return ser.getBookById(id);
	}
	@GetMapping("/search")
	public List<Book> searchTitle(@RequestParam("search") String q) {

		return ser.search(q);

	}

	@PostMapping
	public ResponseEntity<Book> addBook(@RequestBody Book b) {

		return ResponseEntity.ok(ser.addBook(b));

	}

	@PutMapping("/{id}")
	public ResponseEntity<Book> updateBook(@PathVariable long id,@RequestBody Book b) {

		return ResponseEntity.ok(ser.updateBook(id,b));
	}

	@DeleteMapping("/{id}")
	public void deleteBook(@PathVariable long  id) {
	ser.deleteBook(id);
	}



}
