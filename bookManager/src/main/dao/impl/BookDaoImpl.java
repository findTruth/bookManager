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
		List<Book> list = new ArrayList<>();
		String sql = "select b.BUID,b.NAME,b.DATE,b.PRESS,b.AUTHOR,b.VALUE,(select c.KINDNAME from TB_BookKinds c where b.KINDNO=c.KINDNO) AS KIND,b.STATUS from TB_Book b";
		try {
			Statement ps = conn.createStatement();
			ResultSet rs = ps.executeQuery(sql);
			Book book = null;
			while (rs.next()) {
				book = new Book(rs.getString("BUID"), rs.getString("NAME"), rs.getTimestamp("DATE"), rs.getString("PRESS"), rs.getString("AUTHOR"), rs.getString("VALUE"), rs.getString("KIND"), rs.getInt("STATUS"));
				list.add(book);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Book findById(String BUID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Book findByName(String NAME) {
		Book book = null;
		String sql = "select BUID,NAME,DATE,PRESS,AUTHOR,VALUE,KINDNO,STATUS from TB_Book where NAME=?";
		try {
			Connection conn = DBhelper_mysql.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, NAME);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				book = new Book(rs.getString("BUID"), rs.getString("NAME"), rs.getTimestamp("DATE"), rs.getString("PRESS"), rs.getString("AUTHOR"), rs.getString("VALUE"), rs.getString("KINDNO"), rs.getInt("STATUS"));
			}
			DBhelper_mysql.closeConnection(rs, ps, conn);
		} catch (Exception e) {
		}
		return book;
	}
	@Override
	public boolean delete(String BUID) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean add(Book book) {
		boolean flag=false;
		String NAME=book.getNAME();
		Date DATE=book.getDATE();
		String PRESS=book.getPRESS();
		String AUTHOR=book.getAUTHOR();
		String VALUE=book.getVALUE(); 
		String KINDNO=book.getKINDNO();
		int STATUS=book.getSTATUS(); 
		try {
			Connection conn=DBhelper_mysql.getConnection();
			String sql="insert into TB_Book(BUID,NAME,DATE,PRESS,AUTHOR,VALUE,KINDNO,STATUS) values(?,?,?,?,?,?,?,?)";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, BUID);
			ps.setString(2, NAME);
			ps.setDate(3, (java.sql.Date) DATE);
			ps.setString(4, PRESS);
			ps.setString(5, AUTHOR);
			ps.setString(6, VALUE);
			ps.setString(7, KINDNO);
			ps.setInt(8, STATUS);
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
	//书名
	public boolean updatebookName(String BUID, String NAME) {
		String sql = "update TB_Book set  NAME= ? where BUID=?";
		try {
			Connection conn = DBhelper_mysql.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, NAME);
			ps.setString(2, BUID);
			int n = ps.executeUpdate();
			DBhelper_mysql.closeConnection(null, ps, conn);
			if (n==0) {
				return false;
			}else{
				return true;
			}
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean updatebookDate(String BUID, String DATE) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
   //出版社
	public boolean updatebookPress(String BUID, String PRESS) {
		String sql = "update TB_Book set  PRESS= ? where BUID=?";
		try {
			Connection conn = DBhelper_mysql.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, PRESS);
			ps.setString(2, BUID);
			int n = ps.executeUpdate();
			DBhelper_mysql.closeConnection(null, ps, conn);
			if (n==0) {
				return false;
			}else{
				return true;
			}
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	//作者
	public boolean updatebookAuthor(String BUID, String AUTHOR) {
		String sql = "update TB_Book set  AUTHOR= ? where BUID=?";
		try {
			Connection conn = DBhelper_mysql.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, AUTHOR);
			ps.setString(2, BUID);
			int n = ps.executeUpdate();
			DBhelper_mysql.closeConnection(null, ps, conn);
			if (n==0) {
				return false;
			}else{
				return true;
			}
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean updatebookValue(String BUID, String VALUE) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updatebookKindno(String BUID, String KINDNO) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updatebookStatus(String BUID, int STATUS) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
}