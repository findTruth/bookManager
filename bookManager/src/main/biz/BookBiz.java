package main.biz;

import java.util.List;

import main.entity.Book;

public interface BookBiz {
	public List<Book> bookList();
	public Book findById(String BUID); 
}
