package main.dao;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import main.entity.Emp;
import main.javaBean.Bookrecord;
import main.javaBean.EmpWorkItem;

public interface EmployeeDao {
	public List<Emp> listEmp();//员工列表
	public Emp findById(String id);//通过id查询员工
	public Emp findByName(String name);//通过name查询员工
	public boolean del(String id);//删除员工
	public boolean add(Emp emp);//增加员工
	public List<EmpWorkItem> listEmpWork();//员工上班记录
	public boolean addEmpWork(Emp emp);//增加员工上班记录
	public boolean delEmpList(List<String> list);//批量删除员工
	public List<Bookrecord> listbookrecordall();//全表查询
	public List<Bookrecord> listbookrecordByPhone(String phone);
	public List<Bookrecord> listbookrecordByBookName(String bname);
	public boolean changeBookRecordStatus(String RUID,int status);
	public int countBookRecordDay(String RUID);//计数
	//修改员工信息
	public boolean changeAll(Emp emp);
	public boolean updateEmpPassword(String id,String Password);
	public boolean updateEmpAge(String id,String age);
	public boolean updateEmpLastLogin(String id);
	public boolean updateEmpQuan(String id,int Quan);
	public boolean updateEmpStatus(String id,int Status);
}
