package main.dao;

import java.util.List;

import main.entity.User;

public interface UserDao {
	public List<User> userList();//用户列表
	public User findById(String id);//通过id查找用户信息
	public boolean del(User user);//删除用户
	public boolean add(User user);//新增用户
	//修改用户各项信息
	public boolean updateUserNicname(String id,String Nicname);
	public boolean updateUserPassword(String id,String Password);
	public boolean updateUserPhone(String id,String Phone);
	public boolean updateUserQQ(String id,String QQ);
	public boolean updateUserStatus(String id,int Status);
}
