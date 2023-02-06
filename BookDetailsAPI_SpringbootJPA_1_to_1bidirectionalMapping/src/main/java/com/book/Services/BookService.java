package com.book.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.book.dao.BookRepo;
import com.book.model.Book;
@Component
public class BookService {
	
	
	@Autowired
	private BookRepo bookRepo;
	
	//get all books
	public List<Book> getAllBooks(){
		List<Book> list=(List<Book>) this.bookRepo.findAll();
		return list;
	}
	
	//get by id
	public Book getBookById(int id) {
		Book book=null;
		try {
			book=this.bookRepo.findById(id);
		} catch (Exception e2) {
			// TODO: handle exception
			e2.printStackTrace();
		}
		return book;
	}
	
	//add book
	public Book addBook(Book b) {
		Book result=bookRepo.save(b);
		return result;
	}
	
	//delete book
	public void deleteBook(int id) {
		bookRepo.deleteById(id);
	}
	
	
	
	//update book by id
	public void updateBook(Book book,int bookId) {
		book.setId(bookId);
		bookRepo.save(book);
		
		}

}
