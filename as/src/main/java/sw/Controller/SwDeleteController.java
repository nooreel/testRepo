package sw.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import sw.Service.SwService;

@Controller
public class SwDeleteController {

	@Autowired
	SwService swservice;
	
	@RequestMapping(value="swDelete.sw")
	public ModelAndView swDelete(@RequestParam(value="swnumber") String swnumber) {
		ModelAndView mav=new ModelAndView();
		
		mav.setViewName("redirect:EquipSwConfig.es");
		swservice.swDelete(swnumber);
		return mav;
	}
	
}
