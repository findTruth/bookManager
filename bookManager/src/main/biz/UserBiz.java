package main.biz;

import java.util.List;

import main.entity.Book;
import main.entity.User;
import main.javaBean.Bookrecord;

public interface UserBiz {
	//判断注册用户
	public String findYxSj(String EMAIL,String UPHONE);
	//增加用户
	public boolean add(User user);
	//登录查找
	public User check(String user,String pwd);
	//查找手机号码
	public String checkphone(String phone);
	//查找邮箱
	public String checkemail(String email);
	//查找昵称和密保问题
	public String checkNCMB(String ncname,String question,String answer);
	//根据UUID修改密码
	public boolean update(String UUID,String pwd);
	//个人中心页面数据
	public User find(String UUID);
	public boolean findNicname(String Nicname,String longUUID);
	public boolean addndx(String longUUID,String  Nicname,String Action1,String Action2,String Action3,int Sex);
	public boolean addndx(String longUUID,String  Nicname,String Action1,String Action2,String Action3,int Sex,String xinmima);
	//借书记录
	public List<Bookrecord> bookrecordList(String longUUID);
	//全表查询
	public List<User> userList();
}
