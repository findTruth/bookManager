package main.dao;

import java.util.List;

import main.entity.Book;
import main.entity.Emp;
import main.javaBean.Bookkeep;

public interface BookDao {
	//查询
	public List<Book> list();//全表查询
	public Book findById(String BUID);//通过id查询书籍
	public List<Book> findByName(String content);//通过name查询书籍
	public List<Book> findByKind(String type);
	
	public boolean deletebookhelp(String BUID);//删除图书
	
	public boolean add(Book book);//增加图书
	
	//修改
	public boolean updateAll(Book book);
	
	
	
	
}