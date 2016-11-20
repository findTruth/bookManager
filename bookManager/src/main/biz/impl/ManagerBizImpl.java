package main.biz.impl;

import java.sql.SQLException;

import main.biz.ManagerBiz;
import main.dao.impl.ManagerDaoImpl;
import main.entity.Manager;

public class ManagerBizImpl implements ManagerBiz{
	ManagerDaoImpl mdi = new ManagerDaoImpl();
	@Override
	public Manager findByName(String name) throws SQLException {
		return mdi.findByName(name);
	}

	@Override
	public Manager findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void LastLoginTime(String id) throws SQLException {
		mdi.updateManagerLastLoginTime(id);
	}

}
