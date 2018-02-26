package SystemConfig.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SystemConfig.Model.AreaOfficeBean;
import SystemConfig.Model.AreaOfficeDepartmentBean;
import SystemConfig.Model.EmployeeBean;
import SystemConfig.Model.SystemConfigDao;
import User.Model.AreaBean;
import sw.Model.SwBean;

@Service
public class SystemConfigServiceImpl implements SystemConfigService{

	@Autowired
	SystemConfigDao systemconfigdao;
	
	@Override
	public List<AreaBean> getAreaList() {
		return systemconfigdao.getAreaList();
	}

	@Override
	public List<AreaOfficeBean> getOfficeList() {
		return systemconfigdao.getOfficeList();
	}

	@Override
	public List<AreaOfficeDepartmentBean> getDepartmentList() {
		return systemconfigdao.getDepartmentList();
	}

	@Override
	public List<EmployeeBean> getEmployeeList() {
		return systemconfigdao.getEmployeeList();
	}

	@Override
	public List<SwBean> getSwList() {
		return systemconfigdao.getSwList();
	}

	
	
	
	
	
}
