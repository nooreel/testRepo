package UserFound.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SystemConfig.Model.EmployeeBean;
import UserFound.Model.UserFoundDao;
@Service
public class UserFoundServiceImpl {

	@Autowired
	UserFoundDao userFoundDao;
	
	public String getEmployeeNumber(EmployeeBean emb) {
		System.out.println("���ã�� ���� ����");
		
		return userFoundDao.employeeNumberCheck(emb);
	}
	
}
