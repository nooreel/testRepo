package SystemConfig.Controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import SystemConfig.Model.AreaDao;

@Controller
public class AreaDeleteController {

	@Autowired
	AreaDao areadao;
	
	@RequestMapping("DeleteArea.sc")
	public ModelAndView AreaDelete(HttpServletRequest request) {
		String area_seq=request.getParameter("area_seq");
		areadao.deleteArea(area_seq);
		ModelAndView mav=new ModelAndView();
		mav.setViewName("redirect:SystemConfig.sc");
		return mav;
		
	}
}
