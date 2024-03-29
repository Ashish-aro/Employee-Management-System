package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Employee;
import connection.GetConnection;

public class EmployeeDao {
//	public static int check(String name, String pass) {
//		try {
//			int result = 0;
//			String sql = "select * from empmngmt where empname=? and emppass=?";
//			PreparedStatement ps = GetConnection.getConnection().prepareStatement(sql);
//			ps.setString(1, name);
//			int passw = Integer.parseInt(pass);
//			ps.setInt(2, passw);
//			result = ps.executeUpdate();
//			System.out.println(result);
//			return result;
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return 0;
//		
//	}
	public static int insert(Employee employee)
	{
		try {
			int result = 0;
			String sql = "insert into empmngmt(empId,empname,emppass,empemail,empcntry) values(?,?,?,?,?)";
			PreparedStatement ps = GetConnection.getConnection().prepareStatement(sql);
			ps.setInt(1, employee.geteId());
			ps.setString(2, employee.geteName());
			ps.setInt(3, employee.getEpass());
			ps.setString(4, employee.getEemail());
			ps.setString(5, employee.getEcntry());
			
			result = ps.executeUpdate();
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public static boolean delete(int empId)
	{
		try {
			String sql = "delete from empmngmt where empId=?";
			PreparedStatement ps = GetConnection.getConnection().prepareStatement(sql);
			ps.setInt(1, empId);
			
			return ps.executeUpdate()>0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static int update(Employee employee)
	{
		try {
			String sql = "update empmngmt set empname=?, emppass=?, empemail=?, empcntry=? where empId=?";
			PreparedStatement ps = GetConnection.getConnection().prepareStatement(sql);
			ps.setString(1, employee.geteName());
			ps.setInt(2, employee.getEpass());
			ps.setString(3, employee.getEemail());
			ps.setString(4,employee.getEcntry());
			ps.setInt(5, employee.geteId());
			
			return ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public static Employee getEmployee(int empId)
	{
		try {
			String sql = "select * from empmngmt where empId = ?";
			PreparedStatement ps = GetConnection.getConnection().prepareStatement(sql);
			
			ps.setInt(1, empId);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				Employee employee = new Employee();
				employee.seteId(rs.getInt(1));
				employee.seteName(rs.getString(2));
				employee.setEpass(rs.getInt(3));
				employee.setEemail(rs.getString(4));
				employee.setEcntry(rs.getString(5));
				
				return employee;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static List<Employee> getEmployees()
	{
		List<Employee> list = new ArrayList<Employee>();
		try {
			String sql = "select * from empmngmt";
			PreparedStatement ps = GetConnection.getConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				Employee employee = new Employee();
				employee.seteId(rs.getInt(1));
				employee.seteName(rs.getString(2));
				employee.setEpass(rs.getInt(3));
				employee.setEemail(rs.getString(4));
				employee.setEcntry(rs.getString(5));
				
				list.add(employee);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
}
