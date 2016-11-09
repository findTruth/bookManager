package main.biz;

import main.entity.Emp;

public interface EmployeeBiz {
	public Emp findByName(String name);
	public Emp findById(String id);
}
