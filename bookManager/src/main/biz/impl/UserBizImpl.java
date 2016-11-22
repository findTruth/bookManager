package main.biz.impl;

import java.util.ArrayList;
import java.util.List;

import main.biz.UserBiz;
import main.dao.impl.BookDaoImpl;
import main.dao.impl.UserDaoImpl;
import main.entity.User;
import main.javaBean.Bookrecord;

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

	@Override
	public String findYxSj(String EMAIL, String UPHONE) {
		String UUID=userdaoimpl.findYxSj(EMAIL, UPHONE);
		return UUID;
	}

	@Override
	public User find(String UUID) {
		User user=userdaoimpl.find(UUID);
		return user;
	}

	@Override
	public boolean findNicname(String Nicname) {
		boolean flag=userdaoimpl.findNcname(Nicname);
		return flag;
	}

	@Override
	public List<Bookrecord> bookrecordList(String longUUID) {
		List<Bookrecord> list = new ArrayList<>();
		list=userdaoimpl.list(longUUID);
		return list;
	}

	@Override
	public boolean addndx(String longUUID, String Nicname, String Action1, String Action2, String Action3, int Sex) {
		boolean flag=userdaoimpl.addndx(longUUID, Nicname, Action1, Action2, Action3, Sex);
		return false;
	}

	@Override
	public boolean addndx(String longUUID, String Nicname, String Action1, String Action2, String Action3, int Sex,
			String xinmima) {
		boolean flag=userdaoimpl.addndx(longUUID, Nicname, Action1, Action2, Action3, Sex,xinmima);
		return false;
	}

	@Override
	public String findNc(String longUUID) {
		String Nicname=userdaoimpl.findNc(longUUID);
		return Nicname;
	}

	

}
