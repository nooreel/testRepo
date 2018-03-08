package Equipment.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import Equipment.Model.EquipmentBean;
import Equipment.Service.EquipmentService;

@Controller
public class EquipmentUpdateController {

	
	@Autowired
	EquipmentService equipmentservice;
	
	@RequestMapping(value="EquipmentUpdate.eq", method=RequestMethod.GET)
	public ModelAndView EquipmentUpdate(@RequestParam("equipmentid") String equipmentid) {
	ModelAndView mav=new ModelAndView();
	EquipmentBean EquipBean = equipmentservice.EqupimentSelect(equipmentid);
	mav.setViewName("EquipmentUpdateForm");
	mav.addObject("EquipBean", EquipBean);
	return mav;
	
		
	}
	
	@RequestMapping(value="EquipmentUpdate.eq", method=RequestMethod.POST)
	public ModelAndView EquipmentUpdate(EquipmentBean bean) {
		ModelAndView mav=new ModelAndView();
		equipmentservice.EquipmentUpdate(bean);
		
		mav.setViewName("redirect:EquipSwConfig.es");
		return mav;
	}
}
