package SystemConfig.Service;

import java.util.List;
import java.util.Map;

import Paging.SwPaging;
import SystemConfig.Model.AreaOfficeBean;
import SystemConfig.Model.AreaOfficeDepartmentBean;
import SystemConfig.Model.EmployeeBean;
import User.Model.AreaBean;
import sw.Model.SwBean;

public interface SystemConfigService {

	public abstract List<AreaBean> getAreaList();
	public abstract List<AreaOfficeBean> getOfficeList();
	public abstract List<AreaOfficeDepartmentBean> getDepartmentList();
	public abstract List<EmployeeBean> getEmployeeList();

	
}
