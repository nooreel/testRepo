package SystemConfig.Controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import SystemConfig.Model.AreaDao;

import SystemConfig.Service.AreaService;

@Controller
public class AreaDeleteController {

	@Autowired
	AreaService areaservice;
	
	@RequestMapping("DeleteArea.sc")
	public ModelAndView AreaDelete(HttpServletRequest request) {
		String area_seq=request.getParameter("area_seq");
		areaservice.deleteArea(area_seq);
		ModelAndView mav=new ModelAndView();
		mav.setViewName("redirect:SystemConfig.sc");
		return mav;
		
	}
}
