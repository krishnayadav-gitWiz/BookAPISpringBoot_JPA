package com.book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.book.Services.BookService;
import com.book.model.Book;

@RestController
public class BookController {
	@Autowired
	private BookService bookService;
	
	@GetMapping("/books")
	public List<Book> getBooks() {
		
//		Book book=new Book();
//		book.setId(111);
//		book.setTitle("Maths");
//		book.setAuthor("RD sharma");
		return this.bookService.getAllBooks();
		
	}
	
	@GetMapping("/book/{id}")
	public Book getBook(@PathVariable("id") int id) {
		return bookService.getBookById(id);
	}
	
	
	@PostMapping("/book")
	public Book addBook(@RequestBody Book book) {
		Book b=this.bookService.addBook(book);
		return b;
	}
	
	
	@DeleteMapping("/book/{id}")
	public void deleteBook(@PathVariable("id") int id) {
		this.bookService.deleteBook(id);
	}
	
	@PutMapping("/book/{bookId}")
	public Book updateBook(@RequestBody Book book,@PathVariable("bookId") int id) {
		this.bookService.updateBook(book, id);
		return book;
	}

}
