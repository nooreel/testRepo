package EquipSw.Model;

public class EquipSwBean {

	private String equipmentid;
	private int swnumber;
	private int patch_percent;
	private int[] sw;
	private int os;
	private int explorer;
	private String swname;
	private String swversion;
	
	
	
	
	public String getSwversion() {
		return swversion;
	}
	public void setSwversion(String swversion) {
		this.swversion = swversion;
	}
	public String getSwname() {
		return swname;
	}
	public void setSwname(String swname) {
		this.swname = swname;
	}
	public String getEquipmentid() {
		return equipmentid;
	}
	public void setEquipmentid(String equipmentid) {
		this.equipmentid = equipmentid;
	}
	public int getSwnumber() {
		return swnumber;
	}
	public void setSwnumber(int swnumber) {
		this.swnumber = swnumber;
	}
	public int getPatch_percent() {
		return patch_percent;
	}
	public void setPatch_percent(int patch_percent) {
		this.patch_percent = patch_percent;
	}
	public int[] getSw() {
		return sw;
	}
	public void setSw(int[] sw) {
		this.sw = sw;
	}
	public int getOs() {
		return os;
	}
	public void setOs(int os) {
		this.os = os;
	}
	public int getExplorer() {
		return explorer;
	}
	public void setExplorer(int explorer) {
		this.explorer = explorer;
	}
	
	
	
}
