package main.biz;

import java.sql.SQLException;

import main.entity.Manager;

public interface ManagerBiz {
	public Manager findByName(String name) throws SQLException ;
	public Manager findById(String id) throws SQLException ;
	public void LastLoginTime(String id) throws SQLException ;
	public boolean changeEmpQuan(String euid,int quan);
	public boolean changeEmpStatus(String id, int Status);
}
