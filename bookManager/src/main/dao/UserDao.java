package main.dao;

import java.util.List;

import main.entity.BookKeep;
import main.entity.BookRecord;
import main.entity.User;
import main.javaBean.Bookkeep;
import main.javaBean.Bookrecord;
import main.javaBean.UserBen;


public interface UserDao {
	public User findByName(String user,String pwd);//通过账号user查找用户信息
	public boolean del(User user);//删除用户
	public boolean add(User user);//新增用户
	//修改用户各项信息
	public boolean updateUserStatus(String UUID,int Status);
	//注册页面
	public String findYxSj(String EMAIL,String UPHONE);//判断是否注册
	//修改密码查找
	public String checkphone(String phone);//手机查找
	public String checkemail(String email);//邮箱查找
	public String checkNCMB(String ncname, String question, String answer);//查找昵称和密保问题
	public boolean update(String UUID,String pwd);//根据UUID，修改密码
	//个人中心页面
	public User find(String UUID);//根据UUID查找个人中心相关数据
	public boolean findNicname(String Nicname,String longUUID);//查找昵称是否存在
	public boolean addndx(String longUUID,String  Nicname,String Action1,String Action2,String Action3,int Sex);
	public boolean addndx(String longUUID,String  Nicname,String Action1,String Action2,String Action3,int Sex,String xinmima);
	//用户借书记录
	public List<Bookrecord> listbookrecord(String longUUID);//全表查询
	public boolean addborrowbook(BookRecord bookrecord);//增加借书记录
	public List<Bookrecord> listbookrecord(String longUUID,String Content);//根据书名查找
	public boolean FindBookrecord(String BUID);//判断是否收藏的书籍是否存在
	public boolean BookrecordCount(String longUUID);//每个人只能借5本书
	public boolean returnbookrecord(String longUUID,String RUID);//还书
	//用户收藏记录
	public List<Bookkeep> listbookkeep(String longUUID);//全表查询
	public boolean addbookkeep(BookKeep bookkeep);//增加借书记录
	public boolean deletebookkeep(String KUID,String longUUID);//删除收藏记录
	public List<Bookkeep> listbookkeep(String longUUID,String Content);//根据作者或者书名查找
	public boolean FindBookkeep(String BUID);//判断是否收藏的书籍是否存在
	public String findbyKUID(String KUID);//根据收藏记录id查找图书id
	
	//登入界面
	public boolean FindUser(String user);//判断用户是否存在
	public boolean UpdateUserLoginTime(String longUUID);//更新最新登入时间
	public String FindUserLoginTime(String longUUID);//查找最新登入时间
	//用户查找
	public List<UserBen> userList();//用户列表
	public List<UserBen> FindUserbyPhone(String Phone);//根据用户手机号码查询
	public List<UserBen> FindUserbyEMAIL(String Email);//根据用户邮箱查询
	public List<UserBen> FindUserbyNicname(String Nicname);//根据用户昵称查询
}
