package main.biz.impl;

import java.util.List;

import main.biz.BookBiz;
import main.dao.impl.BookDaoImpl;
import main.entity.Book;

public class BookBizImpl implements BookBiz {
	
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

}
