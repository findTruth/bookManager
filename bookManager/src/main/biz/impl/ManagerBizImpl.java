package main.biz.impl;

import main.biz.ManagerBiz;
import main.dao.impl.ManagerDaoImpl;
import main.entity.Manager;

public class ManagerBizImpl implements ManagerBiz {
	ManagerDaoImpl mdi = new ManagerDaoImpl();
	@Override
	public Manager findByName(String name) {
		return mdi.findByName(name);
	}

	@Override
	public Manager findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
