package com.book.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;
import com.book.model.Book;
@Component
public class BookService {
	
	
	private static List<Book> list=new ArrayList<>();
	static{
		list.add(new Book(11,"NCERT maths", "RS aggrawal"));
		list.add(new Book(12,"NCERT english", "jk"));
		list.add(new Book(13,"NCERT chemistry", "S chandra"));
		list.add(new Book(14,"NCERT physics", "Pradeep"));
		list.add(new Book(15,"demo", "d"));
	}
	
	//get all books
	public List<Book> getAllBooks(){
		return list;
	}
	
	//get by id
	public Book getBookById(int id) {
		Book book=null;
		book=list.stream().filter(e->e.getId()==id).findFirst().get();
		return book;
	}
	
	//add book
	public Book addBook(Book b) {
		list.add(b);
		return b;
	}
	
	//delete book
	public void deleteBook(int id) {
//		list=list.stream().filter(b->{
//			if(b.getId()!=id) {
//				return true;
//			}else {
//				return false;
//		}
//		}).collect(Collectors.toList());
		
		
		//or
		
		list=list.stream().filter(b->b.getId()!=id).collect(Collectors.toList());
	}
	
	
	
	//update book by id
	public void updateBook(Book book,int bookId) {
		
		list=list.stream().map(b->{
			if(b.getId()==bookId) {
				b.setTitle(book.getTitle());
				b.setAuthor(book.getAuthor());
			}
			return b;
		}).collect(Collectors.toList());
		
		}

}
