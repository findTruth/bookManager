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
	//查找用户
	public User check(String user, String pwd) {
		User users=userdaoimpl.findByName(user, pwd);
		return users;
	}

}
