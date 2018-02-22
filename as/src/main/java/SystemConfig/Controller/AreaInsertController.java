package SystemConfig.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import SystemConfig.Model.AreaDao;

@Controller
public class AreaInsertController {

	@Autowired
	AreaDao areadao;
	
	@RequestMapping(value="InsertArea.sc",method=RequestMethod.GET)
	public void InsertArea(HttpServletRequest request,HttpServletResponse response) {
		String areaname=request.getParameter("areaname");
		int result=areadao.insertArea(areaname);
		response.setContentType("text/html; charset=UTF-8");
		try {
			PrintWriter out=response.getWriter();
			if(result==1) {
				out.println("<script>");
				out.println("alert('�ǿ��� ���������� �߰��Ǿ����ϴ�');");
				out.println("</script>");
			}else {
				out.println("<script>");
				out.println("alert('�̹� �����ϴ� �ǿ����Դϴ�');");
				out.println("</script>");
			}
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
