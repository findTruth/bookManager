package main.biz;

import java.util.List;

import main.entity.BookKeep;
import main.entity.BookRecord;
import main.entity.User;
import main.javaBean.Bookkeep;
import main.javaBean.Bookrecord;
import main.javaBean.UserBen;


public interface UserBiz {
	public boolean delUserList(List<String> list);//批量删除员工
	//修改用户信息
	public boolean changeUser(User user);
	//修改用户状态
	public boolean changeUserStatus(String UUID,int Status);
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
	public boolean addborrowbook(BookRecord bookrecord);//增加借书记录
	public List<Bookrecord> listbookrecord(String longUUID,String Content);//根据书名查找
	public boolean FindBookrecord(String BUID);//判断是否收藏的书籍是否存在
	public boolean BookrecordCount(String longUUID);//每个人只能借5本书
	public boolean returnbookrecord(String longUUID,String RUID);//还书
	//收藏记录
	public List<Bookkeep> listbookkeep(String longUUID);//全表查询
	public boolean addbookkeep(BookKeep bookkeep);//增加借书记录
	public boolean deletebookkeep(String KUID,String longUUID);//删除收藏记录
	public List<Bookkeep> listbookkeep(String longUUID,String Content);//根据作者或者书名查找
	public boolean FindBookkeep(String BUID);//判断是否收藏的书籍是否存在
	public String findbyKUID(String KUID);//根据收藏记录id查找图书id
	//用户查询
	public List<UserBen> userList(int type,String content);//根据输入type判断查询
	//登入界面
	public boolean FindUser(String user);
	public boolean UpdateUserLoginTime(String longUUID);//更新最新登入时间
	public String FindUserLoginTime(String longUUID);//查找最新登入时间
}
