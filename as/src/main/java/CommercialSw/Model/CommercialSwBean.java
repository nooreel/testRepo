package CommercialSw.Model;

public class CommercialSwBean {
	private String maker;
	private String swname;
	private String used;
	private int quantity;
	private int installquantity;
	private int emptyquantity;
	
	
	public int getInstallquantity() {
		return installquantity;
	}
	public void setInstallquantity(int installquantity) {
		this.installquantity = installquantity;
	}
	public int getEmptyquantity() {
		return emptyquantity;
	}
	public void setEmptyquantity(int emptyquantity) {
		this.emptyquantity = emptyquantity;
	}
	public String getMaker() {
		return maker;
	}
	public void setMaker(String maker) {
		this.maker = maker;
	}
	public String getSwname() {
		return swname;
	}
	public void setSwname(String swname) {
		this.swname = swname;
	}
	public String getUsed() {
		return used;
	}
	public void setUsed(String used) {
		this.used = used;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
}
