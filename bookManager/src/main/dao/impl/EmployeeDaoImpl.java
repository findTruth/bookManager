package main.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import main.dao.EmployeeDao;
import main.entity.Book;
import main.entity.Emp;
import main.entity.Manager;
import main.javaBean.EmpWorkItem;
import main.tool.Tools;
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
						rs.getInt("AGE"), Tools.formatDate(rs.getTimestamp("LASTLOGIN")), rs.getInt("QUAN"), rs.getInt("STATUS"));
				list.add(emp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Emp findById(String id) {
		String sql = "select EUID,UNAME,NAME,PASSWORD,PHONE,QQ,ID,AGE,LASTLOGIN,QUAN,STATUS from tb_emp where EUID = ?";
		Connection conn = DBhelper_mysql.getConnection();
		Emp emp = null;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				emp = new Emp(rs.getString("EUID"), rs.getString("UNAME"), rs.getString("NAME"),
						rs.getString("PASSWORD"), rs.getString("PHONE"), rs.getString("QQ"),
						rs.getString("ID"), rs.getInt("AGE"), Tools.formatDate(rs.getDate("LASTLOGIN")), 
						rs.getInt("QUAN"), rs.getInt("STATUS"));
			}
			DBhelper_mysql.closeConnection(rs, ps, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return emp;
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
						rs.getString("ID"), rs.getInt("AGE"), Tools.formatDate(rs.getDate("LASTLOGIN")), 
						rs.getInt("QUAN"), rs.getInt("STATUS"));
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
		boolean flag=false;
		try {
			Connection conn=DBhelper_mysql.getConnection();
			String sql="insert into TB_Emp(EUID,UNAME,NAME,PASSWORD,PHONE,QQ,ID,AGE,LASTLOGIN,QUAN) values(?,?,?,?,?,?,?,?,now(),?)";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, emp.getEUID());
			ps.setString(2, emp.getUNAME());
			ps.setString(3, emp.getNAME());
			ps.setString(4, emp.getPASSWORD());
			ps.setString(5, emp.getPHONE());
			ps.setString(6, emp.getQQ());
			ps.setString(7, emp.getID());
			ps.setInt(8, emp.getAGE());
			ps.setInt(9, emp.getQUAN());
			int n=ps.executeUpdate();
			if (n==1) {
				flag=true;
			}
			DBhelper_mysql.closeConnection(null, ps, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}


	@Override
	public boolean updateEmpPassword(String id, String Password) {
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
	@Override
	public boolean changeAll(Emp emp) {
		String sql = "update TB_Emp set NAME=?,PHONE=?,QQ=?,ID=?,AGE=?,QUAN = ? where EUID=?";
		try {
			Connection conn = DBhelper_mysql.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
		    ps.setString(1, emp.getNAME());
		    ps.setString(2, emp.getPHONE());
		    ps.setString(3, emp.getQQ());
		    ps.setString(4, emp.getID());
		    ps.setInt(5, emp.getAGE());
		    ps.setInt(6, emp.getQUAN());
		    ps.setString(7, emp.getEUID());
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
	public List<EmpWorkItem> listEmpWork() {
		Connection conn = DBhelper_mysql.getConnection();
		List<EmpWorkItem> list = new ArrayList<>();
		String sql = "select w.WEUID,w.EUID,w.TIME,(select e.NAME from tb_emp e where e.EUID=w.EUID) as ENAME from tb_empwork w Order By w.TIME Desc";
		try {
			Statement ps = conn.createStatement();
			ResultSet rs = ps.executeQuery(sql);
			EmpWorkItem EmpWorkItem = null;
			while (rs.next()) {
				EmpWorkItem = new EmpWorkItem(rs.getString("WEUID"), rs.getString("EUID"), rs.getTimestamp("TIME"), rs.getString("ENAME"));
				list.add(EmpWorkItem);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public boolean addEmpWork(Emp emp) {
		boolean flag = false;
		Connection conn = DBhelper_mysql.getConnection();
		String sql = "insert into tb_empwork(WEUID,EUID,TIME) values(?,?,now())";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, Tools.UUID());
			ps.setString(2, emp.getEUID());
			int n = ps.executeUpdate();
			if(n>0){
				flag = true;
			}else{}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return flag;
	}

	@Override
	public boolean delEmpList(List<String> list) {
		boolean flag=false;
		try {
			Connection conn=DBhelper_mysql.getConnection();
			conn.setAutoCommit(false);
			String sql="delete from TB_Emp where EUID=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			for(String a:list){
				ps.setString(1, a);
				ps.addBatch();
			}
			int n=ps.executeUpdate();
			conn.commit();
			if (n>=1) {
				flag=true;
			}
			DBhelper_mysql.closeConnection(null, ps, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

}
