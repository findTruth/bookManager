package main.biz;

import main.entity.User;

public interface UserBiz {
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
	
}
