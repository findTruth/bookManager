package main.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


import main.dao.UserDao;
import main.entity.BookKeep;
import main.entity.BookRecord;
import main.entity.User;
import main.javaBean.Bookkeep;
import main.javaBean.Bookrecord;
import main.javaBean.UserBen;
import main.tool.Tools;
import main.util.DBhelper_mysql;

public class UserDaoImpl implements UserDao{

	@Override
	public List<UserBen> userList() {
		List<UserBen> list=new ArrayList<UserBen>();
		try {
			Connection conn=DBhelper_mysql.getConnection();
			String sql="select UUID,UPHONE,EMAIL,NICNAME,STATUS,LOGINTIME,SEX,ATION1+ATION2+ATION3 as ACTION from TB_User ORDER BY  LOGINTIME DESC";
			PreparedStatement	ps=conn.prepareStatement(sql);
			ResultSet	rs=ps.executeQuery();
			while (rs.next()) {
				UserBen user1=new UserBen();
				user1.setUUID(rs.getString("UUID"));
				user1.setPHONE(rs.getString("UPHONE"));
				user1.setEMAIL(rs.getString("EMAIL"));
				user1.setNICNAME(rs.getString("NICNAME"));
				user1.setAction(rs.getString("ACTION"));
				user1.setSTATUS(rs.getInt("STATUS"));
				user1.setSEX(rs.getInt("SEX"));
				user1.setLOGINTIME(rs.getString("LOGINTIME"));
				list.add(user1);
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
			String sql="insert into TB_User(UUID,UPHONE,EMAIL,PASSWORD,QUESTION,ANSWER,LOGINTIME) values(?,?,?,?,?,?,now())";
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
			String sql="select NICNAME,UPHONE,EMAIL,SEX,ATION1,ATION2,ATION3,PASSWORD,STATUS from TB_User where UUID=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, UUID);
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				users.setUUID(UUID);
				users.setNICNAME(rs.getString("NICNAME"));
				users.setPHONE(rs.getString("UPHONE"));
				users.setEMAIL(rs.getString("EMAIL"));
				users.setATION1(rs.getString("ATION1"));
				users.setATION2(rs.getString("ATION2"));
				users.setATION3(rs.getString("ATION3"));
				users.setPASSWORD(rs.getString("PASSWORD"));
				users.setSTATUS(rs.getInt("STATUS"));
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
					+ " T.RUID as RUID,"
					+ " B.NAME as NAME,"
					+ "T.STARTTIME as STARTTIME,"
					+ "T.OVERTIME as OVERTIME,"
					+ "T.STATUS as STATUS "
					+ "from TB_BookRecord T,TB_Book B "
					+ "where B.BUID=T.BUID AND T.UUID=? ORDER BY  STARTTIME ASC";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, longUUID);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Bookrecord bookrecord = new Bookrecord();
				bookrecord.setRUID(rs.getString("RUID"));
				bookrecord.setBname(rs.getString("NAME"));	
				bookrecord.setSTARTTIME(Tools.formatDate(rs.getTimestamp("STARTTIME")));
				bookrecord.setOVERTIME(Tools.formatDate(rs.getTimestamp("OVERTIME")));
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
			String sql="insert into TB_BookRecord(RUID,BUID,UUID,STARTTIME,OVERTIME,STATUS) values(?,?,?,now(),?,?)";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, bookrecord.getRUID());
			ps.setString(2, bookrecord.getBUID());
			ps.setString(3, bookrecord.getUUID());
			ps.setDate(4, (Date)bookrecord.getOVERTIME());
			ps.setInt(5, bookrecord.getSTATUS());
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
			String sql = "select T.KUID as KUID,B.NAME as NAME,B.PRESS as PRESS,B.AUTHOR as AUTHOR,B.VALUE as VALUE,T.TIME as TIME from TB_Bookkeep T,TB_Book B where B.BUID=T.BUID AND T.UUID=? ORDER BY  TIME ASC";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, longUUID);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Bookkeep bookkeep = new Bookkeep();
				bookkeep.setKUID(rs.getString("KUID"));
				bookkeep.setNAME(rs.getString("NAME"));
				bookkeep.setPRESS(rs.getString("PRESS"));
				bookkeep.setAUTHOR(rs.getString("AUTHOR"));
				bookkeep.setVALUE(rs.getString("VALUE"));
				bookkeep.setTIME(Tools.formatDate(rs.getTimestamp("TIME")));
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
			String sql="insert into TB_BookKeep(KUID,UUID,BUID,TIME) values(?,?,?,now());";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, bookkeep.getKUID());
			ps.setString(2, bookkeep.getUUID());
			ps.setString(3, bookkeep.getBUID());
//			ps.setDate(4, (Date)bookkeep.getTIME());
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

	@Override
	public boolean UpdateUserLoginTime(String longUUID) {
		boolean flag=false;
		try {
			Connection conn=DBhelper_mysql.getConnection();
			String sql="update TB_User set LOGINTIME=now() where UUID=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, longUUID);
			int n=ps.executeUpdate();
			DBhelper_mysql.closeConnection(null, ps, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public String FindUserLoginTime(String longUUID) {
		String logintime=null;
		try {
			Connection conn=DBhelper_mysql.getConnection();
			String sql="select LOGINTIME from TB_User where UUID=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, longUUID);
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				logintime=(Tools.formatDate(rs.getTimestamp("LOGINTIME")));
			}
			DBhelper_mysql.closeConnection(rs, ps, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return logintime;
	}

	@Override
	public List<Bookkeep> listbookkeep(String longUUID, String Content) {
		List<Bookkeep> list = new ArrayList<>();
		try {
			Connection conn = DBhelper_mysql.getConnection();
			String sql = "select T.KUID as KUID,B.NAME as NAME,B.PRESS as PRESS,B.AUTHOR as AUTHOR,B.VALUE as VALUE,T.TIME as TIME from TB_Bookkeep T,TB_Book B where B.BUID=T.BUID AND T.UUID=? AND T.BUID=(select BUID from TB_Book where NAME=? OR AUTHOR=?) ORDER BY  TIME DESC";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, longUUID);
			ps.setString(2, Content);
			ps.setString(3, Content);
			ResultSet rs = ps.executeQuery(); 	
			while (rs.next()) {
				Bookkeep bookkeep = new Bookkeep();
				bookkeep.setKUID(rs.getString("KUID"));
				bookkeep.setNAME(rs.getString("NAME"));
				bookkeep.setPRESS(rs.getString("PRESS"));
				bookkeep.setAUTHOR(rs.getString("AUTHOR"));
				bookkeep.setVALUE(rs.getString("VALUE"));
				bookkeep.setTIME(Tools.formatDate(rs.getTimestamp("TIME")));
				list.add(bookkeep);
			}
			DBhelper_mysql.closeConnection(rs, ps, conn);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Bookrecord> listbookrecord(String longUUID, String Content) {
		List<Bookrecord> list = new ArrayList<>();
		try {
			Connection conn = DBhelper_mysql.getConnection();
			String sql = "select"
					+ " T.RUID as RUID,"
					+ " B.NAME as NAME,"
					+ "T.STARTTIME as STARTTIME,"
					+ "T.OVERTIME as OVERTIME,"
					+ "T.STATUS as STATUS "
					+ "from TB_BookRecord T,TB_Book B "
					+ "where B.BUID=T.BUID AND T.UUID=? AND T.BUID=(select BUID from TB_Book where NAME=?) ORDER BY  OVERTIME DESC";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, longUUID);
			ps.setString(2, Content);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Bookrecord bookrecord = new Bookrecord();
				bookrecord.setRUID(rs.getString("RUID"));
				bookrecord.setBname(rs.getString("NAME"));	
				bookrecord.setSTARTTIME(Tools.formatDate(rs.getTimestamp("STARTTIME")));
				bookrecord.setOVERTIME(Tools.formatDate(rs.getTimestamp("OVERTIME")));
				bookrecord.setSTATUS(rs.getInt("STATUS"));
				list.add(bookrecord);
			}
			DBhelper_mysql.closeConnection(rs, ps, conn);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public boolean FindBookrecord(String BUID) {
		boolean flag=false;
		String buid=null;
		Timestamp overtime=null;
		try {
			Connection conn=DBhelper_mysql.getConnection();
			String sql="select BUID, OVERTIME from TB_BookRecord where BUID=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, BUID);
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				buid=rs.getString("BUID");	
				overtime=rs.getTimestamp("OVERTIME");
			}
			if (buid!=null&&overtime==null) {
				flag=true;
			}
			DBhelper_mysql.closeConnection(rs, ps, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean FindBookkeep(String BUID) {
		boolean flag=false;
		String buid=null;
		try {
			Connection conn=DBhelper_mysql.getConnection();
			String sql="select BUID from TB_BookKeep where BUID=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, BUID);
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				buid=rs.getString("BUID");	
			}
			if (buid!=null) {
				flag=true;
			}
			DBhelper_mysql.closeConnection(rs, ps, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public String findbyKUID(String KUID) {
		String BUID=null;
		try {
			Connection conn=DBhelper_mysql.getConnection();
			String sql="select BUID from TB_bookkeep where KUID=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, KUID);
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				BUID=rs.getString("BUID");
			}
			DBhelper_mysql.closeConnection(rs, ps, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return BUID;
	}

	@Override
	public boolean BookrecordCount(String longUUID) {
		boolean flag=false;
		int n=0;
		try {
			Connection conn=DBhelper_mysql.getConnection();
			String sql="select count(STATUS) as count from TB_bookrecord where UUID=? AND STATUS=0";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, longUUID);
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				n=rs.getInt("count");
			}
			if (n<5) {
				flag=true;
			}
			DBhelper_mysql.closeConnection(null, ps, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean returnbookrecord(String longUUID, String RUID) {
		boolean flag=false;
		try {
			Connection conn=DBhelper_mysql.getConnection();
			String sql="update TB_Bookrecord set OVERTIME=now(),STATUS=1 where RUID=? and UUID=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, RUID);
			ps.setString(2, longUUID);
			int n=ps.executeUpdate();
			if (n==1) {
				flag=true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public List<UserBen> FindUserbyPhone(String Phone) {
		List<UserBen> list=new ArrayList<UserBen>();
		try {
			Connection conn=DBhelper_mysql.getConnection();
			String sql="select UUID,UPHONE,EMAIL,NICNAME,STATUS,LOGINTIME,SEX,ATION1+ATION2+ATION3 as ACTION from TB_User where UPHONE=? ORDER BY  LOGINTIME DESC";
			PreparedStatement	ps=conn.prepareStatement(sql);
			ps.setString(1, Phone);
			ResultSet	rs=ps.executeQuery();
			while (rs.next()) {
				UserBen user1=new UserBen();
				user1.setUUID(rs.getString("UUID"));
				user1.setPHONE(rs.getString("UPHONE"));
				user1.setEMAIL(rs.getString("EMAIL"));
				user1.setNICNAME(rs.getString("NICNAME"));
				user1.setAction(rs.getString("ACTION"));
				user1.setSTATUS(rs.getInt("STATUS"));
				user1.setSEX(rs.getInt("SEX"));
				user1.setLOGINTIME(rs.getString("LOGINTIME"));
				list.add(user1);
			}
			DBhelper_mysql.closeConnection(rs, ps, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<UserBen> FindUserbyEMAIL(String Email) {
		List<UserBen> list=new ArrayList<UserBen>();
		try {
			Connection conn=DBhelper_mysql.getConnection();
			String sql="select UUID,UPHONE,EMAIL,NICNAME,STATUS,LOGINTIME,SEX,ATION1+ATION2+ATION3 as ACTION from TB_User where EMAIL=? ORDER BY  LOGINTIME DESC";
			PreparedStatement	ps=conn.prepareStatement(sql);
			ps.setString(1, Email);
			ResultSet	rs=ps.executeQuery();
			while (rs.next()) {
				UserBen user1=new UserBen();
				user1.setUUID(rs.getString("UUID"));
				user1.setPHONE(rs.getString("UPHONE"));
				user1.setEMAIL(rs.getString("EMAIL"));
				user1.setNICNAME(rs.getString("NICNAME"));
				user1.setAction(rs.getString("ACTION"));
				user1.setSTATUS(rs.getInt("STATUS"));
				user1.setSEX(rs.getInt("SEX"));
				user1.setLOGINTIME(rs.getString("LOGINTIME"));
				list.add(user1);
			}
			DBhelper_mysql.closeConnection(rs, ps, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<UserBen> FindUserbyNicname(String Nicname) {
		List<UserBen> list=new ArrayList<UserBen>();
		try {
			Connection conn=DBhelper_mysql.getConnection();
			String sql="select UUID,UPHONE,EMAIL,NICNAME,STATUS,LOGINTIME,SEX,ATION1+ATION2+ATION3 as ACTION from TB_User where NICNAME LIKE ? ORDER BY  LOGINTIME DESC";
			PreparedStatement	ps=conn.prepareStatement(sql);
			ps.setString(1, Nicname);
			ResultSet	rs=ps.executeQuery();
			while (rs.next()) {
				UserBen user1=new UserBen();
				user1.setUUID(rs.getString("UUID"));
				user1.setPHONE(rs.getString("UPHONE"));
				user1.setEMAIL(rs.getString("EMAIL"));
				user1.setNICNAME(rs.getString("NICNAME"));
				user1.setAction(rs.getString("ACTION"));
				user1.setSTATUS(rs.getInt("STATUS"));
				user1.setSEX(rs.getInt("SEX"));
				user1.setLOGINTIME(rs.getString("LOGINTIME"));
				list.add(user1);
			}
			DBhelper_mysql.closeConnection(rs, ps, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public boolean changeUser(User user) {
		boolean flag=false;
		try {
			Connection conn=DBhelper_mysql.getConnection();
			String sql="update TB_User set UPHONE=?,EMAIL=?,NICNAME=?,STATUS=?,SEX=? where UUID=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, user.getPHONE());
			ps.setString(2, user.getEMAIL());
			ps.setString(3, user.getNICNAME());
			ps.setInt(4, user.getSTATUS());
			ps.setInt(5, user.getSEX());
			ps.setString(6, user.getUUID());
			int n=ps.executeUpdate();
			DBhelper_mysql.closeConnection(null, ps, conn);
			flag=true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean delUserList(List<String> list) {
		boolean flag=false;
		try {
			Connection conn=DBhelper_mysql.getConnection();
			conn.setAutoCommit(false);
			String sql="delete from TB_User where UUID=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			for(String a:list){
				ps.setString(1, a);
				ps.addBatch();
			}
			int[] n=ps.executeBatch();
			conn.commit();
			if (n.length>=1) {
				flag=true;
			}
			DBhelper_mysql.closeConnection(null, ps, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

}
