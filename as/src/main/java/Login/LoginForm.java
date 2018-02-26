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
		System.out.println("·Î±×ÀÎºä µé¾î¿È");
		return "login";
	}
	
	
	
	
	
}
