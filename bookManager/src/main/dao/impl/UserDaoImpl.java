package main.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import main.dao.UserDao;
import main.entity.Book;
import main.entity.BookRecord;
import main.entity.User;
import main.tool.Tools;
import main.util.DBhelper_mysql;

public class UserDaoImpl implements UserDao{

	@Override
	public List<User> userList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findByName(String user,String pwd) {
		User users=new User();
		try {
			Connection conn=DBhelper_mysql.getConnection();
			String sql="select UUID,UPHONE,EMAIL,PASSWORD,QUESTION,ANSWER,NICNAME,UNAME,STATUS from TB_User where (UPHONE=? or EMAIL=?) AND PASSWORD=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, user);
			ps.setString(2, user);
			ps.setString(3, pwd);
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				users.setUUID(rs.getString("UUID"));
				users.setPHONE(rs.getString("UPHONE"));
				users.setEMAIL(rs.getString("EMAIL"));
				users.setPASSWORD(rs.getString("PASSWORD"));
				users.setSTATUS(rs.getInt("STATUS"));
				users.setNICNAME(rs.getString("NICNAME"));
				users.setUNAME(rs.getString("UNAME"));
			}		
			DBhelper_mysql.closeConnection(rs, ps, conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return users;
	}

	@Override
	public boolean del(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean add(User user) {
		boolean flag=false;
		String PHONE=user.getPHONE();
		String EMAIL=user.getEMAIL();
		String PASSWORD=user.getPASSWORD();
		String QUESTION=user.getQUESTION();
		String ANSWER=user.getANSWER(); 
		try {
			Connection conn=DBhelper_mysql.getConnection();
			String sql="insert into TB_User(UUID,UPHONE,EMAIL,PASSWORD,QUESTION,ANSWER) values(?,?,?,?,?,?)";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, Tools.UUID());
			ps.setString(2, PHONE);
			ps.setString(3, EMAIL);
			ps.setString(4, PASSWORD);
			ps.setString(5, QUESTION);
			ps.setString(6, ANSWER);
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
	public boolean updateUserNicname(String id, String Nicname) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateUserPassword(String id, String Password) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateUserPhone(String id, String Phone) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateUserQQ(String id, String QQ) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateUserStatus(String id, int Status) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public User findById(String UUID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String checkphone(String phone) {
		String UUID=null;
		try {
			Connection conn=DBhelper_mysql.getConnection();
			String sql="select UUID,UPHONE from TB_User where UPHONE=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, phone);
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				UUID=rs.getString("UUID");		
			}
			DBhelper_mysql.closeConnection(rs, ps, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return UUID;
	}

	@Override
	public String checkemail(String email) {
		String UUID=null;
		try {
			Connection conn=DBhelper_mysql.getConnection();
			String sql="select UUID,EMAIL from TB_User where EMAIL=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, email);
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				UUID=rs.getString("UUID");		
			}
			DBhelper_mysql.closeConnection(rs, ps, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return UUID;
	}

	@Override
	public String checkNCMB(String ncname, String question, String answer) {
		String UUID=null;
		try {
			Connection conn=DBhelper_mysql.getConnection();
			String sql="select UUID,NICNAME,QUESTION,ANSWER from TB_User where NICNAME=? AND QUESTION=? AND ANSWER=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, ncname);
			ps.setString(2, question);
			ps.setString(3, answer);
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				UUID=rs.getString("UUID");		
			}
			DBhelper_mysql.closeConnection(null, ps, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return UUID;
	}

	@Override
	public boolean update(String UUID, String pwd) {
		boolean flag=false;
		try {
			Connection conn=DBhelper_mysql.getConnection();
			String sql="update TB_User set PASSWORD=? WHERE UUID=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, pwd);
			ps.setString(2, UUID);
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
	public String findYxSj(String EMAIL, String UPHONE) {
		String UUID=null;
		try {
			Connection conn=DBhelper_mysql.getConnection();
			String sql="select UUID from TB_User where EMAIL=? or UPHONE=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, EMAIL);
			ps.setString(2, UPHONE);
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				 UUID=rs.getString("UUID");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return UUID;
	}

	@Override
	public User find(String UUID) {
		User users=new User();
		try {
			Connection conn=DBhelper_mysql.getConnection();
			String sql="select NICNAME,SEX,ATION1,ATION2,ATION3 from TB_User where UUID=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, UUID);
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				users.setNICNAME(rs.getString("NICNAME"));
				users.setATION1(rs.getString("ATION1"));
				users.setATION2(rs.getString("ATION2"));
				users.setATION3(rs.getString("ATION3"));
			}		
			DBhelper_mysql.closeConnection(rs, ps, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}

	@Override
	public boolean findNcname(String Nicname) {
		boolean flag=true;
		User users=new User();
		try {
			Connection conn=DBhelper_mysql.getConnection();
			String sql="select UUID from TB_User where NICNAME=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, Nicname);
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				users.setUUID(rs.getString("UUID"));
			}		
			DBhelper_mysql.closeConnection(rs, ps, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (users.getUUID()!=null) {
			flag=false;
		}
		return flag;
	}

	@Override
	public List<BookRecord> list(String longUUID) {
		Connection conn = DBhelper_mysql.getConnection();
		List<BookRecord> list = new ArrayList<>();
		String sql = "select B.NAME as Name,T.STARTTIME,T.OVERTIME,T.STATUS from TB_BookRecord T,TB_Book B, where B.BUID=T.BUID AND T.UUID=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, longUUID);
			ResultSet rs = ps.executeQuery(sql);
			while (rs.next()) {
				BookRecord bookrecord = null;
				bookrecord.setBname(rs.getString("Name"));
				bookrecord.setSTARTTIME(rs.getDate("T.STARTTIME"));
				bookrecord.setOVERTIME(rs.getDate("T.OVERTIME"));
				bookrecord.setSTATUS(rs.getInt("T.STATUS"));
				list.add(bookrecord);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}


}
