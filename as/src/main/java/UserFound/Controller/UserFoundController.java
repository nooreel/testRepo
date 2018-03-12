package UserFound.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import SystemConfig.Model.EmployeeBean;
import UserFound.Service.PwFoundServiceImpl;
import UserFound.Service.UserFoundServiceImpl;

@Controller
public class UserFoundController {

	@Autowired
	UserFoundServiceImpl userFoundServiceImpl;
	
	
	
	@RequestMapping(value="userFound.uf",method=RequestMethod.GET)
	public String goEmployeeNumberFoundForm() {
		System.out.println("사번찾기 컨트롤러들어옴");
		return "UserFound";
	}
	@RequestMapping(value="userFound.uf",method=RequestMethod.POST)
	public void employeeNumberFound(HttpServletRequest request,HttpServletResponse response) {
		String userName=request.getParameter("userName");
		String userBirth=request.getParameter("userBirth");
		String userEmail=request.getParameter("userEmail");

		Date date =java.sql.Date.valueOf(userBirth);
		
		EmployeeBean emb = new EmployeeBean();
		emb.setEmployeename(userName);
		emb.setBirth(date);
		emb.setEmail(userEmail);
		
		String result=userFoundServiceImpl.getEmployeeNumber(emb);
	
		System.out.println("result: "+result);
					
		response.setContentType("text/html; charset=UTF-8");

		try {
			PrintWriter out=response.getWriter();
			
			out.println("<script>");
			if(result==null) {
				out.println("alert('입력한 정보와 일치하는 회원이 없습니다');");
				out.println("location.href='userFound.uf';");}
			
			else {
				out.println("alert('당신의 아이디는 "+result+" 입니다');");
				out.println("location.href='login.login';");
			}

			out.println("</script>");
			out.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	}
