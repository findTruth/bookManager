package main.biz.impl;

import java.util.List;

import main.biz.EmployeeBiz;
import main.dao.impl.EmployeeDaoImpl;
import main.entity.Emp;
import main.javaBean.Bookrecord;
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

	@Override
	public boolean addEmp(Emp emp) {
		return edi.add(emp);
	}

	@Override
	public boolean delEmpList(List<String> list) {
		return edi.delEmpList(list);
	}

	@Override
	public List<Bookrecord> bookrecordList(int type, String keyword) {
		if(type==0){
			return edi.listbookrecordall();
		}else if(type==1){
			return edi.listbookrecordByPhone(keyword);
		}else if(type==2){
			return edi.listbookrecordByBookName(keyword);
		}
		return null;
	}

	@Override
	public int huanshuaction(String ruid) {
		edi.changeBookRecordStatus(ruid,1);
		return edi.countBookRecordDay(ruid);
	}

	@Override
	public boolean jieshuaction(String ruid) {
		return edi.changeBookRecordStatus(ruid, 2);
	}


}
