package Login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import User.Model.EmployeeBean;

@Controller
public class LoginController {

	
	@Autowired
	MemberServicelmpl memberServicelmpl;

	
	EmployeeBean vo=new EmployeeBean();
	
	@RequestMapping("loginCheck.login")
	public ModelAndView loginCheck(HttpServletRequest request,HttpSession session) {
		System.out.println("로그인체크");
		
		String id=request.getParameter("userId");
		String pw=request.getParameter("userPw");
		

		
		vo.setEmployeenumber(id);
		vo.setPassword(pw);
		

		boolean result = memberServicelmpl.loginCheck(vo,session);	
		
		ModelAndView mav=new ModelAndView();
		if(result == true){
			mav.setViewName("../testt/index");

		}else{
			mav.setViewName("login");
			mav.addObject("msg","failure");
		}
		return mav;
		
	}

	@RequestMapping("logOut.login")
	public ModelAndView logOut(HttpServletRequest request,HttpSession session){
		ModelAndView mav=new ModelAndView();
		memberServicelmpl.logOut(session);
		mav.setViewName("login");
		System.out.println("로그아웃 성공");
	
		
		
		return mav;
	}
	
}
