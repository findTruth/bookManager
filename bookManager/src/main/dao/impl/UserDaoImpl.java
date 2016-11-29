package main.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.tomcat.dbcp.pool2.BaseObject;

import main.dao.UserDao;
import main.entity.BookKeep;
import main.entity.BookRecord;
import main.entity.User;
import main.javaBean.Bookkeep;
import main.javaBean.Bookrecord;
import main.tool.Tools;
import main.util.DBhelper_mysql;

public class UserDaoImpl implements UserDao{

	@Override
	public List<User> userList() {
		List<User> list=new ArrayList<User>();
		try {
			Connection conn=DBhelper_mysql.getConnection();
			String sql="select UUID,UPHONE,EMAIL,NICNAME,STATUS,ATION1,ATION2,ATION3 from TB_User";
			PreparedStatement	ps=conn.prepareStatement(sql);
			ResultSet	rs=ps.executeQuery();
			while (rs.next()) {
				User user=new User();
				user.setUUID(rs.getString("UUID"));
				user.setPHONE(rs.getString("UPHONE"));
				user.setEMAIL(rs.getString("EMAIL"));
				user.setNICNAME(rs.getString("NICNAME"));
				user.setATION1(rs.getString("ATION1"));
				user.setATION2(rs.getString("ATION2"));
				user.setATION3(rs.getString("ATION3"));
				user.setSTATUS(rs.getInt("STATUS"));
				list.add(user);
			}
			DBhelper_mysql.closeConnection(rs, ps, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
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
			e.printStackTrace();
		}
		return users;
	}

	@Override
	public boolean del(User user) {
		boolean flag=false;
		String UUID=user.getUUID();
		try {
			Connection conn=DBhelper_mysql.getConnection();
			String sql="delete from TB_User where UUID=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, UUID);
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
			e.printStackTrace();
		}
		return flag;
	}

	

	@Override
	public boolean updateUserStatus(String UUID, int Status) {
		boolean flag=false;
		try {
			Connection conn=DBhelper_mysql.getConnection();
			String sql="update TB_User set STATUS=? where UUID=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, Status);
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
			String sql="select NICNAME,SEX,ATION1,ATION2,ATION3,PASSWORD from TB_User where UUID=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, UUID);
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				users.setNICNAME(rs.getString("NICNAME"));
				users.setATION1(rs.getString("ATION1"));
				users.setATION2(rs.getString("ATION2"));
				users.setATION3(rs.getString("ATION3"));
				users.setPASSWORD(rs.getString("PASSWORD"));
				users.setSEX(rs.getInt("SEX"));
			}		
			DBhelper_mysql.closeConnection(rs, ps, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}

	@Override
	public boolean findNicname(String Nicname,String longUUID) {
		boolean flag=true;
		User users=new User();
		try {
			Connection conn=DBhelper_mysql.getConnection();
			String sql="select UUID from TB_User where NICNAME=? and UUID!=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, Nicname);
			ps.setString(2, longUUID);
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
	public List<Bookrecord> listbookrecord(String longUUID) {
		List<Bookrecord> list = new ArrayList<>();
		try {
			Connection conn = DBhelper_mysql.getConnection();
			String sql = "select"
					+ " B.NAME as NAME,"
					+ "T.STARTTIME as STARTTIME,"
					+ "T.OVERTIME as OVERTIME,"
					+ "T.STATUS as STATUS "
					+ "from TB_BookRecord T,TB_Book B "
					+ "where B.BUID=T.BUID AND T.UUID=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, longUUID);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Bookrecord bookrecord = new Bookrecord();
				bookrecord.setBname(rs.getString("NAME"));	
				bookrecord.setSTARTTIME(rs.getDate("STARTTIME"));
				bookrecord.setOVERTIME(rs.getDate("OVERTIME"));
				bookrecord.setSTATUS(rs.getInt("STATUS"));
				list.add(bookrecord);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public boolean addndx(String longUUID, String Nicname, String Action1, String Action2, String Action3, int Sex) {
		boolean flag=false;
		try {
			Connection conn=DBhelper_mysql.getConnection();
			String sql="update TB_User set NICNAME=?,Ation1=?,Ation2=?,Ation3=?,Sex=? where UUID=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, Nicname);
			ps.setString(2, Action1);
			ps.setString(3, Action2);
			ps.setString(4, Action3);
			ps.setInt(5, Sex);
			ps.setString(6, longUUID);
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
	public boolean addndx(String longUUID, String Nicname, String Action1, String Action2, String Action3, int Sex,
			String xinmima) {
		
		boolean flag=false;
		try {
			Connection conn=DBhelper_mysql.getConnection();
			String sql="update TB_User set NICNAME=?,Ation1=?,Ation2=?,Ation3=?,Sex=?,PASSWORD=? where UUID=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, Nicname);
			ps.setString(2, Action1);
			ps.setString(3, Action2);
			ps.setString(4, Action3);
			ps.setInt(5, Sex);
			ps.setString(6, xinmima);
			ps.setString(7, longUUID);
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
	public boolean FindUser(String user) {
		Boolean flag=false;
		String UUID=null;
		try {
			Connection conn=DBhelper_mysql.getConnection();
			String sql="select UUID from TB_User where UPHONE=? or EMAIL=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, user);
			ps.setString(2, user);
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {			
				UUID=rs.getString("UUID");
			}
			if (UUID!=null) {
				flag=true;
			}
			DBhelper_mysql.closeConnection(rs, ps, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}
//	public static void main(String[] args) {
//		UserDaoImpl userdapimpl=new UserDaoImpl();
//		System.out.println(userdapimpl.updateUserStatus("610a4b8997964d4084ef15157951f093", 0));
//	}

	@Override
	public boolean addborrowbook(BookRecord bookrecord) {
		boolean flag=false;
		try {
			Connection conn=DBhelper_mysql.getConnection();
			String sql="insert into TB_Bookrecord(RUUID,BUID,UUID,STARTTIME,OVERTIME,STATUS) values(?,?,?,?,?,?)";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, bookrecord.getRUID());
			ps.setString(2, bookrecord.getBUID());
			ps.setString(3, bookrecord.getUUID());
			ps.setDate(4, (Date) bookrecord.getSTARTTIME());
			ps.setDate(5, (Date)bookrecord.getOVERTIME());
			ps.setInt(6, bookrecord.getSTATUS());
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
	public List<Bookkeep> listbookkeep(String longUUID) {
		List<Bookkeep> list = new ArrayList<>();
		try {
			Connection conn = DBhelper_mysql.getConnection();
			String sql = "select"
					+ "B.NAME as NAME,"
					+ "B.PRESS as PRESS,"
					+ "B.AUTHOR as AUTHOR,"
					+ "B.VALUE as VALUE,"
					+ "T.TIME as TIME,"
					+ "from TB_Bookeep T,TB_Book B"
					+ "where B.BUID=T.BUID AND T.UUID=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, longUUID);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Bookkeep bookkeep = new Bookkeep();
				bookkeep.setNAME(rs.getString("NAME"));
				bookkeep.setPRESS(rs.getString("PRESS"));
				bookkeep.setAUTHOR(rs.getString("AUTHOR"));
				bookkeep.setVALUE(rs.getString("VALUE"));
				bookkeep.setTIME(rs.getDate("TIME"));
				list.add(bookkeep);
			}
			DBhelper_mysql.closeConnection(rs, ps, conn);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public boolean addbookkeep(BookKeep bookkeep) {
		Boolean flag=false;
		try {
			Connection conn=DBhelper_mysql.getConnection();
			String sql="insert into TB_BookKeep values(?,?,?,?);";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, bookkeep.getKUID());
			ps.setString(2, bookkeep.getBUID());
			ps.setString(3, bookkeep.getUUID());
			ps.setDate(4, (Date)bookkeep.getTIME());
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
	public boolean deletebookkeep(String KUID,String longUUID) {
		boolean flag=false;
		try {
			Connection conn=DBhelper_mysql.getConnection();
			String sql="delete from TB_BookKeep where KUID=? AND UUID=?";
			PreparedStatement	ps=conn.prepareStatement(sql);
			ps.setString(1, KUID);
			ps.setString(2, longUUID);
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

}
