package Equipment.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import Equipment.Service.EquipmentService;



@Controller
public class EquipmentDeleteController {

	@Autowired
	EquipmentService equipmentservice;
	
	@RequestMapping(value="EquipmentDelete.eq", method=RequestMethod.GET)
	public ModelAndView EquipmentDelete(@RequestParam("equipmentid") String equipmentid) {
		ModelAndView mav = new ModelAndView();
		equipmentservice.EquipmentDelete(equipmentid);
		mav.setViewName("redirect:EquipSwConfig.es");
		return mav;
	}
		
	}
	

