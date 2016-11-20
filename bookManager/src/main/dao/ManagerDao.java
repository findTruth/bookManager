package main.dao;

import java.sql.SQLException;

import main.entity.Manager;

public interface ManagerDao {
	public Manager findById(String id) throws SQLException ;
	public Manager findByName(String name) throws SQLException ;
	//修改manager数据
	public void updateManagerLastLoginTime(String id) throws SQLException ;
}
