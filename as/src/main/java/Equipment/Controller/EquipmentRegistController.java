package Equipment.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import Equipment.Model.EquipmentBean;
import Equipment.Service.EquipmentService;

@Controller
public class EquipmentRegistController {

	@Autowired
	EquipmentService equipmentservice;
	
	
	
	@RequestMapping(value="EquipmentRegist.eq",method=RequestMethod.GET)
	public String goEquipmentRegistForm() {
		return "EquipmentRegistForm";
	}
	
	@RequestMapping(value="EquipmentRegist.eq",method=RequestMethod.POST)
	public void EquipmentRegistProc(EquipmentBean bean,HttpServletResponse response) {
		
		equipmentservice.EquipmentRegist(bean);
		String equipmentid=bean.getEquipmentid();
		response.setContentType("text/html; charset=UTF-8");
		try {
			PrintWriter out=response.getWriter();
			out.println("<script>");
			out.println("var answer=confirm('장비등록이 완료되었습니다. 장비에 설치된 SW를 등록하시겠습니까?');");
			out.println("alert(answer);");
			out.println("if(answer==true){");
			out.println("location.href='EquipSwInsert.es?equipmentid="+equipmentid+"';");
			out.println("}else{");
			out.println("location.href='EquipSwConfig.es'");
			out.println("};");
			out.println("</script>");
			out.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
