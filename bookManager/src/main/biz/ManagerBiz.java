package main.biz;

import java.sql.SQLException;

import main.entity.Manager;

public interface ManagerBiz {
	public Manager findByName(String name) throws SQLException ;
	public Manager findById(String id) throws SQLException ;
	public void LastLoginTime(String id) throws SQLException ;
}
