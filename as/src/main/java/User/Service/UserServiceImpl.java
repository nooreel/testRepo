package User.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import User.Model.AreaBean;
import User.Model.DepartmentBean;
import User.Model.EmployeeBean;
import User.Model.OfficeBean;
import User.Model.UserDao;
@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserDao userdao;
	
	@Override
	public List<AreaBean> getAreaList() {
		List<AreaBean> list=userdao.getAreaList();
		return list;
	}

	@Override
	public List<OfficeBean> getOfficeList(String area_seq) {
		List<OfficeBean> list=userdao.getOfficeList(area_seq);
		return list;
	}

	@Override
	public List<DepartmentBean> getDepartmentList(String office_seq) {
		List<DepartmentBean> list=userdao.getDepartmentList(office_seq);
		return list;
	}

	@Override
	public String employeeNumberCheck(String employeenumber) {
		String result=userdao.employeeNumberCheck(employeenumber);
		return result;
	}

	@Override
	public int insertUser(EmployeeBean eb) {
		int result=userdao.insertUser(eb);
		return result;
	}

}
