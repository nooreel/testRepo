package Login;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class LoginForm {

	@Autowired
	SqlSessionTemplate sqlsessiontemplate;
	
	@RequestMapping("login.login")
	public String goLogin() {
		System.out.println("�α��κ� ����");
		return "login";
	}
	
	
	
	
	
}
