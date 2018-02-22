package SystemConfig.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import SystemConfig.Model.AreaDao;

@Controller
public class AreaUpdateController {

	@Autowired
	AreaDao areadao;
	
	@RequestMapping("UpdateArea.sc")
	public void UpdateArea(HttpServletRequest request,HttpServletResponse response) {
		String areaname=request.getParameter("areaname");
		String area_seq=request.getParameter("area_seq");
		
		areadao.updateArea(area_seq,areaname);
		System.out.println("수정완료");
		
	}
	
}
