package SystemConfig.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import SystemConfig.Model.AreaOfficeBean;
import SystemConfig.Model.OfficeDao;
import SystemConfig.Model.SystemConfigDao;
import SystemConfig.Service.OfficeService;
import SystemConfig.Service.SystemConfigService;
import User.Model.AreaBean;

@Controller
public class OfficeUpdateController {
	
	@Autowired
	OfficeService officeservice;
	
	@Autowired
	SystemConfigService systemconfigservice;
	
	@RequestMapping(value="EditOffice.sc",method=RequestMethod.GET)
	public ModelAndView goOfficeUpdateForm(@RequestParam("office_seq") String office_seq) {
		ModelAndView mav=new ModelAndView();
		
		AreaOfficeBean bean=officeservice.getOfficeRecord(office_seq);
		mav.addObject("bean",bean);
		mav.setViewName("OfficeUpdateForm");
		
		List<AreaBean> arealist=systemconfigservice.getAreaList();
		mav.addObject("arealist",arealist);
		
		return mav;
	}
	
	@RequestMapping(value="EditOffice.sc",method=RequestMethod.POST)
	public String OfficeUpdateProc(@RequestParam("office_seq") String office_seq,
			@RequestParam("area_seq") String area_seq,
			@RequestParam("officename") String officename) {
		
		AreaOfficeBean bean=new AreaOfficeBean();
		bean.setArea_seq(Integer.parseInt(area_seq));
		bean.setOffice_seq(Integer.parseInt(office_seq));
		bean.setOfficename(officename);

		officeservice.updateOffice(bean);
		
		return "redirect:SystemConfig.sc";
	}
}
