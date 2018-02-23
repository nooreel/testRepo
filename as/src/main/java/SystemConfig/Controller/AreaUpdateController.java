package SystemConfig.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


import SystemConfig.Service.AreaService;

@Controller
public class AreaUpdateController {

	@Autowired
	AreaService areaservice;
	
	@RequestMapping("UpdateArea.sc")
	public void UpdateArea(HttpServletRequest request,HttpServletResponse response) {
		String area_seq=request.getParameter("area_seq");
		String areaname=request.getParameter("areaname");
		areaservice.UpdateaArea(area_seq, areaname);
	}
	
}
