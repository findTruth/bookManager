package main.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import main.dao.BookDao;
import main.entity.Book;
import main.entity.Emp;
import main.entity.User;
import main.tool.Tools;
import main.util.DBhelper_mysql;

public class BookDaoImpl implements BookDao {

	private static final String BUID = null;

	@Override
	public List<Book> list() {
		Connection conn = DBhelper_mysql.getConnection();
		List<Book> list = new ArrayList<Book>();
		String sql = "select b.BUID,b.NAME,b.DATE,b.PRESS,b.AUTHOR,b.VALUE,(select c.KINDNAME from TB_BookKinds c where b.KINDNO=c.KINDNO) AS KIND,b.STATUS,b.ADDRESS,b.PICTURE from TB_Book b";
		System.out.println("11111");
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			Book book = null;
			while (rs.next()) {
				book = new Book(rs.getString("BUID"), rs.getString("NAME"), rs.getTimestamp("DATE"), rs.getString("PRESS"), rs.getString("AUTHOR"), rs.getString("VALUE"), rs.getString("KIND"),rs.getString("ADDRESS"), rs.getInt("STATUS"),rs.getString("PICTURE"));
				list.add(book);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Book findById(String BUID) {
		String sql = "select BUID,NAME,PRESS,AUTHOR,KINDNO,VALUE,STATUS,DATE,ADDRESS,PICTURE from TB_Book where BUID = ?";
		Connection conn = DBhelper_mysql.getConnection();
		Book book = null;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, BUID);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				System.out.println(rs.getString("BUID"));
				book = new Book(rs.getString("BUID"), rs.getString("NAME"), rs.getTimestamp("DATE"), rs.getString("PRESS"), rs.getString("AUTHOR"), rs.getString("VALUE"), rs.getString("KINDNO"),rs.getString("ADDRESS"), rs.getInt("STATUS"),rs.getString("PICTURE"));;
			}
			DBhelper_mysql.closeConnection(rs, ps, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return book;
	}


	@Override
	public Book findByName(String NAME) {
		String sql = "select BUID,NAME,DATE,PRESS,AUTHOR,VALUE,KINDNO,STATUS,ADDRESS,PICTURE from TB_Book where NAME=?";
		Book book = null;
		try {
			Connection conn = DBhelper_mysql.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, NAME);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				 book = new Book(rs.getString("BUID"), rs.getString("NAME"), rs.getTimestamp("DATE"), rs.getString("PRESS"), rs.getString("AUTHOR"), rs.getString("VALUE"), rs.getString("KIND"),rs.getString("ADDRESS"), rs.getInt("STATUS"),rs.getString("PICTURE"));;
			}
			DBhelper_mysql.closeConnection(rs, ps, conn);
		} catch (Exception e) {
		}
		return book;
	}

	@Override
	public boolean add(Book book) {
		boolean flag=false;
		String BUID=book.getBUID();
		String NAME=book.getNAME();
		Date DATE=book.getDATE();
		String PRESS=book.getPRESS();
		String AUTHOR=book.getAUTHOR();
		String VALUE=book.getVALUE(); 
		String KINDNO=book.getKINDNO();
		String ADDRESS=book.getADDRESS();
		int STATUS=book.getSTATUS(); 
		String PICTURE=book.getPICTURE();
		try {
			Connection conn=DBhelper_mysql.getConnection();
			String sql="insert into TB_Book(BUID,NAME,DATE,PRESS,AUTHOR,VALUE,KINDNO,ADDRESS,STATUS,PICTURE) values(?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, BUID);
			ps.setString(2, NAME);
			ps.setDate(3, (java.sql.Date) DATE);
			ps.setString(4, PRESS);
			ps.setString(5, AUTHOR);
			ps.setString(6, VALUE);
			ps.setString(7, KINDNO);
			ps.setString(8, ADDRESS);
			ps.setInt(9, STATUS);
			ps.setString(10, PICTURE);
			int n=ps.executeUpdate();
			if (n==1) {
				flag=true;
			}
			DBhelper_mysql.closeConnection(null, ps, conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}
	
	

	@Override
	public boolean deletebookhelp(String BUID) {
		boolean flag=false;
		try {
			Connection conn=DBhelper_mysql.getConnection();
			String sql="delete from TB_Book where BUID=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, BUID);
			int n=ps.executeUpdate();
			if (n==1) {
				flag=true;
			}
			DBhelper_mysql.closeConnection(null, ps, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	
//修改图书
@Override
public boolean updateAll(Book book) {
	boolean flag=false;
	try {
		Connection conn=DBhelper_mysql.getConnection();
		String sql="update TB_Book set NAME=?,PRESS=?,AUTHOR=?,VALUE=?,KINDNO=?,STATUS=?,DATE=?,ADDRESS,PICTURE Where BUID=?";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setString(1, book.getNAME());
	    ps.setString(2, book.getPRESS());
	    ps.setString(3, book.getAUTHOR());
	    ps.setString(4, book.getVALUE());
	    ps.setString(5, book.getKINDNO());
	    ps.setInt(6, book.getSTATUS());
	    ps.setDate(7, (java.sql.Date) book.getDATE());
	    ps.setString(8, book.getADDRESS());
	    ps.setString(9, book.getPICTURE());
	    ps.setString(10, book.getBUID());
		int n=ps.executeUpdate();
		 if (n==1) {
			flag=true;
		}
		 DBhelper_mysql.closeConnection(null, ps, conn);
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return flag;
}

  public static void main(String[] args) {
	  List<Book> list = new BookDaoImpl().list();
	  
	  System.out.println(list.size());
}


}