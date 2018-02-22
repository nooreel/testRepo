package SystemConfig.Model;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DepartmentDao {

	@Autowired
	SqlSessionTemplate sqlsessiontemplate;
	
	private final String namespace="DepartmentMapper";
	
	public void deleteDepartment(String department_seq) {
		sqlsessiontemplate.update(namespace+".DeleteDepartment",department_seq);
		
	}
	
	public void InsertDepartment(AreaOfficeDepartmentBean bean) {
		sqlsessiontemplate.insert(namespace+".InsertDepartment",bean);
	}
	
	public AreaOfficeDepartmentBean getDepartmentRecord(String department_seq) {
		AreaOfficeDepartmentBean bean=sqlsessiontemplate.selectOne(namespace+".GetDepartmentRecord",department_seq);
		return bean;
	}
	
	public void UpdateDepartment(AreaOfficeDepartmentBean bean) {
		sqlsessiontemplate.update(namespace+".UpdateDepartment",bean);
		
	}
	
}
