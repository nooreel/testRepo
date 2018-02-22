package User.Model;

import java.sql.Date;


public class EmployeeBean {
	private int area_seq;
	private int office_seq;
	private int department_seq;
	private String employeenumber;
	private String password;
	private Date birth;
	private String employeename;
	private String employeeposition;
	private int privilege;
	private String email;
	
	
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	public int getArea_seq() {
		return area_seq;
	}
	public void setArea_seq(int area_seq) {
		this.area_seq = area_seq;
	}
	public int getOffice_seq() {
		return office_seq;
	}
	public void setOffice_seq(int office_seq) {
		this.office_seq = office_seq;
	}
	public int getDepartment_seq() {
		return department_seq;
	}
	public void setDepartment_seq(int department_seq) {
		this.department_seq = department_seq;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmployeename() {
		return employeename;
	}
	public void setEmployeename(String employeename) {
		this.employeename = employeename;
	}

	public int getPrivilege() {
		return privilege;
	}
	public void setPrivilege(int privilege) {
		this.privilege = privilege;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEmployeenumber() {
		return employeenumber;
	}
	public void setEmployeenumber(String employeenumber) {
		this.employeenumber = employeenumber;
	}
	public String getEmployeeposition() {
		return employeeposition;
	}
	public void setEmployeeposition(String employeeposition) {
		this.employeeposition = employeeposition;
	}
	
	
	
}
