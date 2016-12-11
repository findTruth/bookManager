package main.biz;

import java.util.List;

import main.entity.Book;
import main.entity.User;

public interface BookBiz {
	public List<Book> bookList();
	public Book findById(String BUID);//通过书籍编号查询
	public List<Book> findByName(String twoNAME);//通过书籍名称查询
	public boolean add(Book book);//添加书籍
	public boolean deletebookhelp(String BUID);//删除图书
	
	public boolean updateAll(Book book);//修改图书
		
}
