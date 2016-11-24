package main.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import main.dao.EmployeeDao;
import main.entity.Book;
import main.entity.Emp;
import main.entity.Manager;
import main.util.DBhelper_mysql;

public class EmployeeDaoImpl implements EmployeeDao {

	@Override
	public List<Emp> listEmp() {
		Connection conn = DBhelper_mysql.getConnection();
		List<Emp> list = new ArrayList<>();
		String sql = "select EUID,UNAME,NAME,PASSWORD,PHONE,QQ,ID,AGE,LASTLOGIN,QUAN,STATUS from TB_Emp";
		try {
			Statement ps = conn.createStatement();
			ResultSet rs = ps.executeQuery(sql);
			Emp emp = null;
			while (rs.next()) {
				emp = new Emp(rs.getString("EUID"), rs.getString("UNAME"), rs.getString("NAME"),
						rs.getString("PASSWORD"), rs.getString("PHONE"), rs.getString("QQ"), rs.getString("ID"),
						rs.getInt("AGE"), rs.getTimestamp("LASTLOGIN"), rs.getInt("QUAN"), rs.getInt("STATUS"));
				list.add(emp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
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
		String sql = "update TB_Emp set AGE = ? where EUID=?";
		try {
			Connection conn = DBhelper_mysql.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, Age);
			ps.setString(2, id);
			int n = ps.executeUpdate();
			DBhelper_mysql.closeConnection(null, ps, conn);
			if (n==0) {
				return false;
			}else{
				return true;
			}
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean updateEmpLastLogin(String id) {
		String sql = "update TB_Emp set LASTLOGIN = now() where EUID=?";
		try {
			Connection conn = DBhelper_mysql.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			int n = ps.executeUpdate();
			DBhelper_mysql.closeConnection(null, ps, conn);
			if (n==0) {
				return false;
			}else{
				return true;
			}
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean updateEmpQuan(String id, int Quan) {
		String sql = "update TB_Emp set QUAN = ? where EUID=?";
		try {
			Connection conn = DBhelper_mysql.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, Quan);
			ps.setString(2, id);
			int n = ps.executeUpdate();
			DBhelper_mysql.closeConnection(null, ps, conn);
			if (n==0) {
				return false;
			}else{
				return true;
			}
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean updateEmpStatus(String id, int Status) {
		String sql = "update TB_Emp set STATUS = ? where EUID=?";
		try {
			Connection conn = DBhelper_mysql.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, Status);
			ps.setString(2, id);
			int n = ps.executeUpdate();
			DBhelper_mysql.closeConnection(null, ps, conn);
			if (n==0) {
				return false;
			}else{
				return true;
			}
		} catch (Exception e) {
			return false;
		}
	}

}
