package main.dao.impl;

import java.sql.Connection;
import java.util.List;

import main.dao.UserDao;
import main.entity.User;
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
		
		Connection conn=DBhelper_mysql.getConnection();
		String sql="insert into TB_user() values(?,?,?,?,?,?)";
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
