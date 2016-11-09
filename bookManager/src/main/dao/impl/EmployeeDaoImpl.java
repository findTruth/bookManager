package main.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import main.dao.EmployeeDao;
import main.entity.Emp;
import main.entity.Manager;
import main.util.DBhelper_mysql;

public class EmployeeDaoImpl implements EmployeeDao {

	@Override
	public List<Emp> listEmp() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Emp findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Emp findByName(String name) {
		Emp emp = null;
		String sql = "select EUID,UNAME,NAME,PASSWORD,PHONE,QQ,ID,AGE,LASTLOGIN,QUAN,STATUS from TB_Emp where UNAME=?";
		try {
			Connection conn = DBhelper_mysql.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				emp = new Emp(rs.getString("EUID"), rs.getString("UNAME"), rs.getString("NAME"),
						rs.getString("PASSWORD"), rs.getString("PHONE"), rs.getString("QQ"),
						rs.getString("ID"), rs.getInt("AGE"), rs.getDate("LASTLOGIN"), 
						rs.getInt("AGE"), rs.getInt("AGE"));
			}
			DBhelper_mysql.closeConnection(rs, ps, conn);
		} catch (Exception e) {
		}
		return emp;
	}

	@Override
	public boolean del(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean add(Emp emp) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateEmpName(String id, String name) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateEmpPassword(String id, String Password) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateEmpPhone(String id, String Phone) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateEmpQQ(String id, String QQ) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateEmpId(String id, String Id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateEmpAge(String id, String Age) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateEmpLastLogin(String id, Date LastLogin) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateEmpQuan(String id, int Quan) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateEmpStatus(String id, int Status) {
		// TODO Auto-generated method stub
		return false;
	}

}
