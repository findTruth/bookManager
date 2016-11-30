package main.biz.impl;

import java.util.ArrayList;
import java.util.List;

import main.biz.UserBiz;
import main.dao.impl.BookDaoImpl;
import main.dao.impl.UserDaoImpl;
import main.entity.BookKeep;
import main.entity.BookRecord;
import main.entity.User;
import main.javaBean.Bookkeep;
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
	public boolean findNicname(String Nicname,String longUUID) {
		boolean flag=userdaoimpl.findNicname(Nicname,longUUID);
		return flag;
	}

	@Override
	public List<Bookrecord> bookrecordList(String longUUID) {
		List<Bookrecord> list = new ArrayList<>();
		list=userdaoimpl.listbookrecord(longUUID);
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
	public List<User> userList() {
		List<User> list=userdaoimpl.userList();
		return list;
	}

	@Override
	public boolean FindUser(String user) {
		boolean flag=userdaoimpl.FindUser(user);
		return flag;
	}

	@Override
	public boolean addborrowbook(BookRecord bookrecord) {
		boolean flag=userdaoimpl.addborrowbook(bookrecord);
		return flag;
	}

	@Override
	public List<Bookkeep> listbookkeep(String longUUID) {
		List<Bookkeep> list=userdaoimpl.listbookkeep(longUUID);
		return list;
	}

	@Override
	public boolean addbookkeep(BookKeep bookkeep) {
		boolean flag=userdaoimpl.addbookkeep(bookkeep);
		return flag;
	}

	@Override
	public boolean deletebookkeep(String KUID, String longUUID) {
		boolean flag=userdaoimpl.deletebookkeep(KUID, longUUID);
		return flag;
	}

	@Override
	public boolean UpdateUserLoginTime(String date, String longUUID) {
		boolean flag=userdaoimpl.UpdateUserLoginTime(date, longUUID);
		return flag;
	}

	@Override
	public String FindUserLoginTime(String longUUID) {
		String logintime=userdaoimpl.FindUserLoginTime(longUUID);
		return logintime;
	}

	@Override
	public List<Bookkeep> listbookkeep(String longUUID, String Content) {
		List<Bookkeep> list=userdaoimpl.listbookkeep(longUUID,Content);
		return list;
	}

	@Override
	public List<Bookrecord> listbookrecord(String longUUID, String Content) {
		List<Bookrecord> list=userdaoimpl.listbookrecord(longUUID, Content);
		return list;
	}

	@Override
	public boolean FindBookrecord(String BUID) {
		boolean flag=userdaoimpl.FindBookrecord(BUID);
		return flag;
	}

	@Override
	public boolean FindBookkeep(String BUID) {
		boolean flag=userdaoimpl.FindBookkeep(BUID);
		return flag;
	}

	
}
