package main.biz.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import main.biz.BookBiz;
import main.dao.impl.BookDaoImpl;
import main.dao.impl.UserDaoImpl;
import main.entity.Book;
import main.entity.Manager;
import main.entity.User;
import main.javaBean.Bookkeep;

public class BookBizImpl implements BookBiz {
	private static final String BUID = null;
	private static final String NAME = null;
	BookDaoImpl bookdaoimpl=new BookDaoImpl();
	
	@Override
	public List<Book> bookList() {
		BookDaoImpl bdi = new BookDaoImpl();
		return bdi.list();
	}

	@Override
	public Book findById(String BUID) {
		
		return bookdaoimpl.findById(BUID);
	}

	@Override
	public List<Book> findByName(String content) {
		List<Book> list=bookdaoimpl.findByName(content);
		return list;
	}
          //添加书籍
	@Override
	public boolean add(Book book) {
		boolean flag=false;
		flag=bookdaoimpl.add(book);
		return flag;
	}

	public boolean deletebookhelp(String BUID) {
		boolean flag=bookdaoimpl.deletebookhelp(BUID);
		return flag;
		
	}

	public boolean updateAll(Book book) {
		return bookdaoimpl.updateAll(book);
	}

	@Override
	public List<Book> findList(String type, String content) {
		List<Book> list=new ArrayList<Book>();
		if (type!=""&&content.equals("类别查找")) {
			list=bookdaoimpl.findByKind(type);
		}else if(type.equals("名字查找")&&content!=""){
			System.out.println("名字");
			list=bookdaoimpl.findByName(content);
		}else{
			list=bookdaoimpl.list();
		}
		return list;
	}

	@Override
	public List<Book> findByKind(String type) {
		List<Book> list=bookdaoimpl.findByKind(type);
		return list;
	}

	

}
