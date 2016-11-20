package main.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import main.dao.BookDao;
import main.entity.Book;
import main.util.DBhelper_mysql;

public class BookDaoImpl implements BookDao {

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

}
