package UserFound.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.Random;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.runner.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Printer;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import SystemConfig.Model.EmployeeBean;
import UserFound.Service.PwFoundServiceImpl;
import UserFound.Service.UserFoundServiceImpl;

@Controller
public class PwFoundController {

	@Autowired
	JavaMailSender mailsender;
	
	@Autowired
	PwFoundServiceImpl pwFoundServiceImpl;
	
	public String result="";
	private String userNum="";

	@RequestMapping(value= "pwFound.uf",method=RequestMethod.GET)
	public String goEmployeeNumberFoundForm() {
		System.out.println("비번찾기 컨트롤러들어옴");
		return "PwFound";
	}
	
	@RequestMapping(value= "pwFoundAuth.uf")
	public void employeeNumberFound(HttpServletRequest request,HttpServletResponse response,User.Model.EmployeeBean emb) {
		
	
		String userName=request.getParameter("name");
		String userBirth=request.getParameter("birth");
		String userEmail=request.getParameter("email");
		userNum=request.getParameter("num");

		Date date =java.sql.Date.valueOf(userBirth);
		
		
		emb.setEmployeename(userName);
		emb.setBirth(date);
		emb.setEmail(userEmail);
		emb.setEmployeenumber(userNum);
		
	
		
		result=pwFoundServiceImpl.getEmployeePw(emb);

		System.out.println("result: "+result);
					
		response.setContentType("text/html; charset=UTF-8");

		try {
			PrintWriter out=response.getWriter();
			
			if(result==null) {
			
				out.println("<script>");
				out.println("alert('입력한 정보와 일치하는 회원이 없습니다');");
				out.println("</script>");
				
			}
			else {
				System.out.println("엘스");
				
				out.println("<script>");
				out.println("var pmt=prompt('메일로 발송된 인증번호를 입력해주세요');");
				out.println("</script>");
				
				
				MailSend(request,emb);
				
				
				
				//out.println("aaa.uf?inputji=inputji");
				//out.println("window.open('pwFoundAuth.uf','');");
			
				}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
				}
	
	}
	
	public void MailSend(HttpServletRequest request,User.Model.EmployeeBean emb) {
		
		
		
		
		int ran = new Random().nextInt(10000)+1000;
		if(ran>10000) {
			ran=(ran-1000);
		}
		String auth=Integer.toString(ran);
		emb.setAuth(auth);
		
		pwFoundServiceImpl.pwAuthPush(emb);
		
		
	
	try {
		 MimeMessage message = mailsender.createMimeMessage();
		  MimeMessageHelper messageHelper;
		  
		messageHelper = new MimeMessageHelper(message, true,"UTF-8");
		 
		  messageHelper.setTo(result);
		  System.out.println("받는사람 이메일 :"+result);
		  messageHelper.setText("이메일 인증번호 : " + emb.getAuth());
		  System.out.println("이메일 인증번호 :"+ emb.getAuth());
		  messageHelper.setFrom("leejinseo41@gmail.com");
		  messageHelper.setSubject("이메일 인증번호 안내");
		
		   mailsender.send(message);
	} catch (MessagingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	}
	
	@RequestMapping("codecheck.uf")
	public void PwAuth(HttpServletRequest request,HttpServletResponse response,User.Model.EmployeeBean emb) {
		
		String empnum=request.getParameter("num");
		String pmt=request.getParameter("pmt");
		
		
		emb.setAuth(pmt);//prompt에 유저가 입력한 값익고
		
		//포름프트에 유저가 입력한 값으로 DB를 조회했을 때의 결과
	String num =pwFoundServiceImpl.pwAuthNumCheck(emb);
		
		
		
		try {
			PrintWriter out=response.getWriter();
			
			if(emb.getAuth().equals(num)){
				System.out.println("인증값 같음");
				out.println("<script>");
				out.println("location.href='pwChange.uf?empnum="+empnum+"'");
				out.println("</script>");
				
			}else {
				System.out.println("인증값 다름");
				out.println("<script>");
				out.println("alert('인증번호가 틀렸습니다')");
				out.println("</script>");
			}
			out.flush();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	@RequestMapping(value= "pwChange.uf",method=RequestMethod.GET)
	public ModelAndView goPwChangeForm(HttpServletRequest request) {
		System.out.println("비번변경 페이지 들어옴");
		
		String empnum=request.getParameter("empnum");
		ModelAndView mav=new ModelAndView();
		mav.addObject("empnum",empnum);
		mav.setViewName("PwFoundAuth");
		
		
		return mav;
	}
	
	
	
	
	@RequestMapping(value="pwAuth.uf",method=RequestMethod.POST)
	public ModelAndView PwUdate(HttpServletRequest request,User.Model.EmployeeBean emb) {
		ModelAndView mav = new ModelAndView();
		String authpw = request.getParameter("authPW");
		String empnum=request.getParameter("empnum");
		
		emb.setPassword(authpw);
		emb.setEmployeenumber(empnum);
		
		
		pwFoundServiceImpl.pwChange(emb);
		
		pwFoundServiceImpl.DeleteNumber(emb);
		mav.setViewName("redirect:login.login");
		return mav;
		
		
		
	}
}
