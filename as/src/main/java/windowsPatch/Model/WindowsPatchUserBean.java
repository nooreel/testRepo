package windowsPatch.Model;

import java.sql.Date;

public class WindowsPatchUserBean {
	private String areaname;
	private String officename;
	private String departmentname;
	private String employeename;
	private String equipmentid;
	private String equipmentip;
	private Date modified;
	private int patch_percent;
	
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
	public String getEmployeename() {
		return employeename;
	}
	public void setEmployeename(String employeename) {
		this.employeename = employeename;
	}
	public String getEquipmentid() {
		return equipmentid;
	}
	public void setEquipmentid(String equipmentid) {
		this.equipmentid = equipmentid;
	}
	public String getEquipmentip() {
		return equipmentip;
	}
	public void setEquipmentip(String equipmentip) {
		this.equipmentip = equipmentip;
	}
	public Date getModified() {
		return modified;
	}
	public void setModified(Date modified) {
		this.modified = modified;
	}
	public int getPatch_percent() {
		return patch_percent;
	}
	public void setPatch_percent(int patch_percent) {
		this.patch_percent = patch_percent;
	}
	
	
}
