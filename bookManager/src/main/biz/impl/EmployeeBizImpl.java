package main.biz.impl;

import main.biz.EmployeeBiz;
import main.dao.impl.EmployeeDaoImpl;
import main.entity.Emp;

public class EmployeeBizImpl implements EmployeeBiz {
	EmployeeDaoImpl edi = new EmployeeDaoImpl();
	@Override
	public Emp findByName(String name) {
		return edi.findByName(name);
	}

	@Override
	public Emp findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
