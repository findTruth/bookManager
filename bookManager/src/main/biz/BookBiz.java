package main.biz;

import java.util.List;

import main.entity.Book;
import main.entity.User;

public interface BookBiz {
	public List<Book> bookList();
	public Book findById(String BUID);//通过书籍编号查询
	public Book findByName(String NAME);//通过书籍名称查询
	public boolean add(Book book);//添加书籍
	
}
