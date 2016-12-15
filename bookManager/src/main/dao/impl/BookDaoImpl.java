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
import main.javaBean.Bookkeep;
import main.tool.Tools;
import main.util.DBhelper_mysql;

public class BookDaoImpl implements BookDao {

	private static final String BUID = null;

	@Override
	public List<Book> list() {
		Connection conn = DBhelper_mysql.getConnection();
		List<Book> list = new ArrayList<Book>();
		String sql = "select b.BUID,b.NAME,b.DATE,b.PRESS,b.AUTHOR,b.VALUE,(select c.KINDNO from TB_BookKinds c where b.KINDNO=c.KINDNO) AS KIND,b.STATUS,b.ADDRESS,b.PICTURE from TB_Book b";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			Book book = null;
			while (rs.next()) {
				book = new Book(rs.getString("BUID"), rs.getString("NAME"), Tools.formatDate(rs.getTimestamp("DATE")), rs.getString("PRESS"), rs.getString("AUTHOR"), rs.getString("VALUE"), rs.getString("KIND"),rs.getString("ADDRESS"), rs.getInt("STATUS"),rs.getString("PICTURE"));
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
				book = new Book(rs.getString("BUID"), rs.getString("NAME"), Tools.formatDate(rs.getTimestamp("DATE")), rs.getString("PRESS"), rs.getString("AUTHOR"), rs.getString("VALUE"), rs.getString("KINDNO"),rs.getString("ADDRESS"), rs.getInt("STATUS"),rs.getString("PICTURE"));;
			}
			DBhelper_mysql.closeConnection(rs, ps, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return book;
	}
	@Override
	public boolean add(Book book) {
		boolean flag=false;
		String BUID=book.getBUID();
		String NAME=book.getNAME();
		String DATE=book.getDATE();
		String PRESS=book.getPRESS();
		String AUTHOR=book.getAUTHOR();
		String VALUE=book.getVALUE(); 
		String KINDNO=book.getKINDNO();
		String ADDRESS=book.getADDRESS();
		int STATUS=book.getSTATUS(); 
		String PICTURE=book.getPICTURE();
		try {
			Connection conn=DBhelper_mysql.getConnection();
			String sql="insert into TB_Book(BUID,NAME,DATE,PRESS,AUTHOR,VALUE,KINDNO,ADDRESS,STATUS,PICTURE) values(?,?,now(),?,?,?,?,?,?,?)";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, BUID);
			ps.setString(2, NAME);
			ps.setString(3, PRESS);
			ps.setString(4, AUTHOR);
			ps.setString(5, VALUE);
			ps.setString(6, KINDNO);
			ps.setString(7, ADDRESS);
			ps.setInt(8, STATUS);
			ps.setString(9, PICTURE);
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
		String sql="update TB_Book set NAME=?,PRESS=?,AUTHOR=?,VALUE=?,KINDNO=?,STATUS=?,DATE=now(),ADDRESS=?,PICTURE=? Where BUID=?";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setString(1, book.getNAME());
	    ps.setString(2, book.getPRESS());
	    ps.setString(3, book.getAUTHOR());
	    ps.setString(4, book.getVALUE());
	    ps.setString(5, book.getKINDNO());
	    ps.setInt(6, book.getSTATUS());
	    ps.setString(7, book.getADDRESS());
	    ps.setString(8, book.getPICTURE());
	    ps.setString(9, book.getBUID());
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
@Override
public List<Book> findByName(String content) {
	List<Book> list = new ArrayList<>();
	try {
		Connection conn = DBhelper_mysql.getConnection();
		String sql = "select b.BUID,b.NAME,b.DATE,b.PRESS,b.AUTHOR,b.VALUE,(select c.KINDNO from TB_BookKinds c where b.KINDNO=c.KINDNO) AS KIND,b.STATUS,b.ADDRESS,b.PICTURE from TB_Book b where b.NAME=? or b.AUTHOR=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, content);
		ps.setString(2, content);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Book book = new Book();
			book.setBUID(rs.getString("BUID"));
			book.setNAME(rs.getString("NAME"));
			book.setAUTHOR(rs.getString("AUTHOR"));
			book.setSTATUS(rs.getInt("STATUS"));
			book.setPRESS(rs.getString("PRESS"));
			book.setVALUE(rs.getString("VALUE"));
			book.setKINDNO(rs.getString("KIND"));
			book.setADDRESS(rs.getString("ADDRESS"));
			book.setPICTURE(rs.getString("PICTURE"));
			list.add(book);
		}
		DBhelper_mysql.closeConnection(rs, ps, conn);
	} catch (Exception e) {
		e.printStackTrace();
	}
	return list;
}
@Override
public List<Book> findByKind(String type) {
	List<Book> list = new ArrayList<>();
	try{
		Connection conn = DBhelper_mysql.getConnection();
		String sql = "select b.BUID,b.NAME,b.DATE,b.PRESS,b.AUTHOR,b.VALUE,(select c.KINDNO from TB_BookKinds c where b.KINDNO=c.KINDNO) AS KIND,b.STATUS,b.ADDRESS,b.PICTURE from TB_Book b where b.KINDNO=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, type);	
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Book book = new Book();	
			book.setBUID(rs.getString("BUID"));
			book.setNAME(rs.getString("NAME"));
			book.setAUTHOR(rs.getString("AUTHOR"));
			book.setSTATUS(rs.getInt("STATUS"));
			book.setPRESS(rs.getString("PRESS"));
			book.setVALUE(rs.getString("VALUE"));
			book.setKINDNO(rs.getString("KIND"));
			book.setADDRESS(rs.getString("ADDRESS"));
			book.setPICTURE(rs.getString("PICTURE"));		
			list.add(book);
		}
		DBhelper_mysql.closeConnection(rs, ps, conn);
	} catch (Exception e) {
		e.printStackTrace();
	}
	return list;
}
//测试
      // public static void main(String[] args) {
	 // BookDaoImpl bookdaoimp=new BookDaoImpl();
     // List<Book> list = bookdaoimp.findByKind("1");
	  //for (Book b:list) {
		//System.out.println(b.getNAME());
		//System.out.println(b.getAUTHOR());
	//}
// }

}