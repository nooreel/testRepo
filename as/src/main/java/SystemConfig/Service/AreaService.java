package SystemConfig.Service;



public interface AreaService {
	
	public abstract int insertArea(String areaname);
	public abstract void deleteArea(String area_seq);
	public void UpdateaArea(String area_seq,String areaname);
	
}
