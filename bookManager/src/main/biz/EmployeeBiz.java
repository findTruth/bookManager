package main.biz;

import java.util.List;

import main.entity.Emp;
import main.javaBean.EmpWorkItem;

public interface EmployeeBiz {
	public Emp findByName(String name);
	public Emp findById(String id);
	public List<Emp> empList();
	public boolean changeAll(Emp emp);
	public List<EmpWorkItem> listEmpWork();//员工上班记录
	public boolean addEmpWork(String EUID);//增加员工上班记录
	public boolean addEmp(Emp emp);//增加员工
}
