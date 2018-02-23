package User.Service;

import java.util.List;

import User.Model.AreaBean;
import User.Model.DepartmentBean;
import User.Model.EmployeeBean;
import User.Model.OfficeBean;

public interface UserService {
	public abstract List<AreaBean> getAreaList();
	public abstract List<OfficeBean> getOfficeList(String area_seq);
	public abstract List<DepartmentBean> getDepartmentList(String office_seq);
	public abstract String employeeNumberCheck(String employeenumber);
	public abstract int insertUser(EmployeeBean eb);
}
