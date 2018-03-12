package UserFound.Service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SystemConfig.Model.EmployeeBean;
import UserFound.Model.PwFoundDao;

@Service
public class PwFoundServiceImpl {

	@Autowired
	PwFoundDao pwFoundDao;
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	public String getEmployeePw(User.Model.EmployeeBean emb) {
		System.out.println("비번찾기 서비스 들어옴");
		return pwFoundDao.employeePwCheck(emb);
	}
	
	public String pwAuthNumCheck(User.Model.EmployeeBean emb) {
		System.out.println("인증번호 서비스 들어옴");
	
		String result=pwFoundDao.pwAuthCheck(emb);
		return result;
	}
	
	
	public void pwAuthPush(User.Model.EmployeeBean emb) {
		pwFoundDao.pwAuthPush(emb);
	}
	
	
	public void pwChange(User.Model.EmployeeBean emb) {
		pwFoundDao.pwChange(emb);
		System.out.println("비번변경 서비스");
	}
	public void DeleteNumber(User.Model.EmployeeBean emb) {
		pwFoundDao.DeleteNum(emb);
		System.out.println("삭제 서비스");
	}
	
}
