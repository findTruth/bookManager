package main.biz.impl;

import java.util.List;

import main.biz.EmployeeBiz;
import main.dao.impl.EmployeeDaoImpl;
import main.entity.Emp;
import main.javaBean.EmpWorkItem;

public class EmployeeBizImpl implements EmployeeBiz {
	EmployeeDaoImpl edi = new EmployeeDaoImpl();
	@Override
	public Emp findByName(String name) {
		return edi.findByName(name);
	}

	@Override
	public Emp findById(String id) {
		return edi.findById(id);
	}

	@Override
	public List<Emp> empList() {
		return new EmployeeDaoImpl().listEmp();
	}

	@Override
	public boolean changeAll(Emp emp) {
		return edi.changeAll(emp);
	}

	@Override
	public List<EmpWorkItem> listEmpWork() {
		return edi.listEmpWork();
	}

	@Override
	public boolean addEmpWork(String EUID) {
		Emp emp = new Emp();
		emp.setEUID(EUID);
		return edi.addEmpWork(emp);
	}

}
