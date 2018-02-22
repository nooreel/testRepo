package testt;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainPageControlloer {
	@Autowired
	SqlSessionTemplate sqlsessiontemplate;
	
	@RequestMapping("goMain.mainpage")
	public String goMain() {
		System.out.println("컨트롤러 들어옴");
		return "index";
	}
	
}
