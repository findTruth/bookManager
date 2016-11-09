package main.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;


import main.dao.UserDao;
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
	public User findById(String id) {
		// TODO Auto-generated method stub
		return null;
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

}
