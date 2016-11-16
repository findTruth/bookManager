package main.biz.impl;

import main.biz.UserBiz;
import main.dao.impl.UserDaoImpl;
import main.entity.User;

public class UserBizImpl implements UserBiz{
	UserDaoImpl userdaoimpl=new UserDaoImpl();

	@Override
	//增加用户
	public boolean add(User user) {
		boolean flag=false;
		flag=userdaoimpl.add(user);
		return flag;
	}

	@Override
	//登录查找
	public User check(String user, String pwd) {
		User users=userdaoimpl.findByName(user, pwd);
		return users;
	}

	@Override
	//查找手机号码
	public String checkphone(String phone) {
		String UUID;
		UUID=userdaoimpl.checkphone(phone);	
		return UUID;
	}

	@Override
	//查找邮箱
	public String checkemail(String email) {
		String UUID;
		UUID=userdaoimpl.checkemail(email);
		return UUID;
	}

	@Override
	//查找昵称和密保问题
	public String checkNCMB(String ncname, String question, String answer) {
		String UUID;
		UUID=userdaoimpl.checkNCMB(ncname, question, answer);
		return UUID;
	}

	@Override
	public boolean update(String UUID,String pwd) {
		boolean flag=false;
		flag=userdaoimpl.update(UUID, pwd);
		return flag;
	}

}
