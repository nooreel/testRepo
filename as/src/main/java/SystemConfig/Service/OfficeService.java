package SystemConfig.Service;

import java.util.Map;

import SystemConfig.Model.AreaOfficeBean;

public interface OfficeService {
	
	public abstract void DeleteOffice(String office_seq);
	public abstract void InsertOffice(Map<String,String> map);
	public abstract AreaOfficeBean getOfficeRecord(String office_seq);
	public abstract void updateOffice(AreaOfficeBean bean);

}
