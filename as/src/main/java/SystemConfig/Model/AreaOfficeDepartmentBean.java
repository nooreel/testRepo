package SystemConfig.Model;

public class AreaOfficeDepartmentBean {
	private int department_seq;
	private String areaname;
	private String officename;
	private String departmentname;
	private int office_seq;
	private int area_seq;
	
	
	public int getOffice_seq() {
		return office_seq;
	}
	public void setOffice_seq(int office_seq) {
		this.office_seq = office_seq;
	}
	public int getArea_seq() {
		return area_seq;
	}
	public void setArea_seq(int area_seq) {
		this.area_seq = area_seq;
	}
	public int getDepartment_seq() {
		return department_seq;
	}
	public void setDepartment_seq(int department_seq) {
		this.department_seq = department_seq;
	}
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

	
	
}
