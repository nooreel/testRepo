package UserFound.Model;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import SystemConfig.Model.EmployeeBean;

@Component
public class UserFoundDao {

	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	private final String namespace="UserFoundMapper";
	
	
	public String employeeNumberCheck(EmployeeBean emb) {
		System.out.println("���ã�� DAO����");
		String chkresult=sqlSessionTemplate.selectOne(namespace+".UserFoundList",emb);
		
		return chkresult;
	}
	
}
