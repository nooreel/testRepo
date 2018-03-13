package sw.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import sw.Model.SwBean;
import sw.Service.SwService;

@Controller
public class SwUpdateController {

	@Autowired
	SwService swservice;
	
	@RequestMapping(value="swUpdate.sw",method=RequestMethod.GET)
	public ModelAndView goSwUpdateForm(@RequestParam("swnumber") String swnumber) {
		ModelAndView mav=new ModelAndView();
		mav.setViewName("SwUpdateForm");
		
		SwBean swbean=swservice.getSwRecord(swnumber);
		mav.addObject("swbean",swbean);
		
		return mav;
	}
	
	@RequestMapping(value="swUpdate.sw",method=RequestMethod.POST)
	public String SwUpdateProc(SwBean bean) {
		swservice.swUpdate(bean);
		return "redirect:EquipSwConfig.es";
		
	}
	
}
