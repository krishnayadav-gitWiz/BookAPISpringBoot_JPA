package com.book.dao;

import org.springframework.data.repository.CrudRepository;


import com.book.model.Book;

public interface BookRepo extends CrudRepository<Book, Integer>{
	
	public Book findById(int id);

}
