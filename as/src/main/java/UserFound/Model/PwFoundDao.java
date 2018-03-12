package UserFound.Model;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import SystemConfig.Model.EmployeeBean;


@Component
public class PwFoundDao {

	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	private final String namespace="UserFoundMapper"; 
	
	public String employeePwCheck(User.Model.EmployeeBean emb) {
		System.out.println("비번찾기 DAO");
		String result = sqlSessionTemplate.selectOne(namespace+".PwFoundList",emb);
		return result;
	}
	
	public int pwAuthPush(User.Model.EmployeeBean emb) {
		int result = sqlSessionTemplate.insert(namespace+".AuthList",emb);
		
		 return result;
	}
	
	public String pwAuthCheck(User.Model.EmployeeBean emb) {
		String result = sqlSessionTemplate.selectOne(namespace+".AuthPwList",emb);
		
		return result;
	}
	
	
	public void pwChange(User.Model.EmployeeBean emb) {
		  sqlSessionTemplate.update(namespace+".PwChange",emb);
		  System.out.println("비번변경 DAO");
	}
	public void DeleteNum(User.Model.EmployeeBean emb) {
		sqlSessionTemplate.delete(namespace+".DeleteNum",emb);
		System.out.println("삭제DAO");
	}
	
}
