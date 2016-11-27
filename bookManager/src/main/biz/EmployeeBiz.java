package main.biz;

import java.util.List;

import main.entity.Emp;

public interface EmployeeBiz {
	public Emp findByName(String name);
	public Emp findById(String id);
	public List<Emp> empList();
	public boolean changeAll(Emp emp);
}
