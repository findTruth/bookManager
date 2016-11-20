package main.dao;

import java.util.List;

import main.entity.Book;
import main.entity.BookRecord;
import main.entity.User;

public interface UserDao {
	public List<User> userList();//用户列表
	public User findById(String UUID);//通过账号UUID查找用户信息
	public User findByName(String user,String pwd);//通过账号user查找用户信息
	public boolean del(User user);//删除用户
	public boolean add(User user);//新增用户
	//修改用户各项信息
	public boolean updateUserNicname(String id,String Nicname);
	public boolean updateUserPassword(String id,String Password);
	public boolean updateUserPhone(String id,String Phone);
	public boolean updateUserQQ(String id,String QQ);
	public boolean updateUserStatus(String id,int Status);
	//注册页面
	public String findYxSj(String EMAIL,String UPHONE);//判断是否注册
	//修改密码查找
	public String checkphone(String phone);//手机查找
	public String checkemail(String email);//邮箱查找
	public String checkNCMB(String ncname, String question, String answer);//查找昵称和密保问题
	public boolean update(String UUID,String pwd);//根据UUID，修改密码
	//个人中心页面
	public User find(String UUID);//根据UUID查找个人中心相关数据
	public boolean findNcname(String Nicname);//查找昵称是否存在
	
	//用户借书记录
	public List<BookRecord> list(String longUUID);
}
