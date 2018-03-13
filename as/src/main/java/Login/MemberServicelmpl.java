package Login;

import javax.servlet.http.HttpSession;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import User.Model.EmployeeBean;


@Component
public class MemberServicelmpl {

	@Autowired
	MemberDAO memberDao;
	@Autowired
	SqlSessionTemplate sqlsessiontemplate;
	
	public boolean loginCheck(EmployeeBean vo, HttpSession session) {
		
		boolean result = memberDao.loginCheck(vo);
		if(result){
			System.out.println(vo.getEmployeenumber());
			System.out.println(vo.getPassword());
			EmployeeBean loginuser=sqlsessiontemplate.selectOne("LoginMapper.GetLoginRecord",vo);
			session.setAttribute("loginuser",loginuser);

		}
		
		return result;
	}
	
	public void logOut(HttpSession session){
		session.removeAttribute("userId");
		session.invalidate();
	}

	
}
