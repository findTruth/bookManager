package main.biz;

import java.util.List;

import main.entity.Book;
import main.entity.User;

public interface BookBiz {
	public List<Book> bookList();
	public Book findById(String BUID);//通过书籍编号查询
	public List<Book> findByName(String content);//通过书籍名称查询
	public List<Book> findByKind(String type);
	public boolean add(Book book);//添加书籍
	public boolean deletebookhelp(String BUID);//删除图书
	
	public boolean updateAll(Book book);//修改图书
	public List<Book> findList(String type,String content);
}
