package SystemConfig.Service;

import SystemConfig.Model.AreaOfficeDepartmentBean;

public interface DepartmentService {
	public abstract void deleteDepartment(String department_seq);
	public abstract void InsertDepartment(AreaOfficeDepartmentBean bean);
	public abstract AreaOfficeDepartmentBean getDepartmentRecord(String department_seq);
	public abstract void UpdateDepartment(AreaOfficeDepartmentBean bean);
}
