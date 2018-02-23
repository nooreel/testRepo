package SystemConfig.Model;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmployeeDao {
	
	@Autowired
	SqlSessionTemplate sqlsessiontemplate;
	
	private final String namespace="EmployeeMapper";
	
	public void DeleteEmployee(String employeenumber) {
		sqlsessiontemplate.update(namespace+".DeleteEmployee",employeenumber);
	}
}
