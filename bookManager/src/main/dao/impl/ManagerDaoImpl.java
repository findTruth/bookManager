package main.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import main.dao.ManagerDao;
import main.entity.Manager;
import main.util.DBhelper_mysql;

public class ManagerDaoImpl implements ManagerDao {

	@Override
	public Manager findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Manager findByName(String name) {
		Manager manager = null;
		String sql = "select MUID,UNAME,PASSWORD,EMAIL,LASTLOGINTIME from TB_Manager where UNAME=?";
		try {
			Connection conn = DBhelper_mysql.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				manager = new Manager(rs.getString("MUID"), rs.getString("UNAME"), rs.getString("PASSWORD")
						, rs.getString("EMAIL"), rs.getTimestamp("LASTLOGINTIME"));
			}
			System.out.println(rs.getTimestamp("LASTLOGINTIME"));
			DBhelper_mysql.closeConnection(rs, ps, conn);
		} catch (Exception e) {
		}
		return manager;
	}

	@Override
	public void updateManagerLastLoginTime(String id) {
		String sql = "update TB_Manager set LASTLOGINTIME = now() where MUID = ?";
		try {
			Connection conn = DBhelper_mysql.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			int n = ps.executeUpdate();
			DBhelper_mysql.closeConnection(null, ps, conn);
		} catch (Exception e) {
		}
	}

}
