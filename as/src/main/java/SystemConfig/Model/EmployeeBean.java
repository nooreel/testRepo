package SystemConfig.Model;

import java.sql.Date;

public class EmployeeBean {
	private String areaname;
	private String officename;
	private String departmentname;
	private String employeenumber;
	private Date birth;
	private String employeename;
	private String employeeposition;
	public String getAreaname() {
		return areaname;
	}
	public void setAreaname(String areaname) {
		this.areaname = areaname;
	}
	public String getOfficename() {
		return officename;
	}
	public void setOfficename(String officename) {
		this.officename = officename;
	}
	public String getDepartmentname() {
		return departmentname;
	}
	public void setDepartmentname(String departmentname) {
		this.departmentname = departmentname;
	}
	public String getEmployeenumber() {
		return employeenumber;
	}
	public void setEmployeenumber(String employeenumber) {
		this.employeenumber = employeenumber;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	public String getEmployeename() {
		return employeename;
	}
	public void setEmployeename(String employeename) {
		this.employeename = employeename;
	}
	public String getEmployeeposition() {
		return employeeposition;
	}
	public void setEmployeeposition(String employeeposition) {
		this.employeeposition = employeeposition;
	}
	
	
}
