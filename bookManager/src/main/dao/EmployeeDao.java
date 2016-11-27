package main.dao;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import main.entity.Emp;

public interface EmployeeDao {
	public List<Emp> listEmp();//员工列表
	public Emp findById(String id);//通过id查询员工
	public Emp findByName(String name);//通过name查询员工
	public boolean del(String id);//删除员工
	public boolean add(Emp emp);//增加员工
	//修改员工信息
	public boolean changeAll(Emp emp);
	public boolean updateEmpPassword(String id,String Password);
	public boolean updateEmpAge(String id,String age);
	public boolean updateEmpLastLogin(String id);
	public boolean updateEmpQuan(String id,int Quan);
	public boolean updateEmpStatus(String id,int Status);
}
