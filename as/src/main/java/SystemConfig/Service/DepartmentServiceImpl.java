package SystemConfig.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Service;

import SystemConfig.Model.AreaOfficeDepartmentBean;
import SystemConfig.Model.DepartmentDao;

@Service
public class DepartmentServiceImpl implements DepartmentService{

	@Autowired
	DepartmentDao departmentdao;
	
	@Override
	public void deleteDepartment(String department_seq) {
		departmentdao.deleteDepartment(department_seq);
	}

	@Override
	public void InsertDepartment(AreaOfficeDepartmentBean bean) {
		departmentdao.InsertDepartment(bean);
	}

	@Override
	public AreaOfficeDepartmentBean getDepartmentRecord(String department_seq) {
		AreaOfficeDepartmentBean bean=departmentdao.getDepartmentRecord(department_seq);
		return bean;
	}

	@Override
	public void UpdateDepartment(AreaOfficeDepartmentBean bean) {
		departmentdao.UpdateDepartment(bean);
	}

}
