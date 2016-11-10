package main.biz;

import main.entity.User;

public interface UserBiz {
	//增加用户
	public boolean add(User user);
	//根据手机号码或者邮箱查找
	public User check(String user,String pwd);
}
