package main.biz.impl;

import java.sql.SQLException;
import java.util.List;

import main.biz.BookBiz;
import main.dao.impl.BookDaoImpl;
import main.dao.impl.UserDaoImpl;
import main.entity.Book;
import main.entity.Manager;
import main.entity.User;

public class BookBizImpl implements BookBiz {
	BookDaoImpl bookdaoimpl=new BookDaoImpl();
	
	@Override
	public List<Book> bookList() {
		BookDaoImpl bdi = new BookDaoImpl();
		return bdi.list();
	}

	@Override
	public Book findById(String BUID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Book findByName(String NAME) {
		
		return bookdaoimpl.findByName(NAME);
	}
          //添加书籍
	@Override
	public boolean add(Book book) {
		boolean flag=false;
		flag=bookdaoimpl.add(book);
		return flag;
	}

}
