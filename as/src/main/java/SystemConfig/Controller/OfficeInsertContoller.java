package SystemConfig.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import SystemConfig.Model.AreaDao;
import SystemConfig.Model.AreaOfficeBean;
import SystemConfig.Model.OfficeDao;
import SystemConfig.Model.SystemConfigDao;
import SystemConfig.Service.OfficeService;
import SystemConfig.Service.SystemConfigService;
import User.Model.AreaBean;

@Controller
public class OfficeInsertContoller {
	
	@Autowired
	SystemConfigService systemconfigservice;
	
	@Autowired
	OfficeService officeservice;
	
	@RequestMapping(value="InsertOffice.sc",method=RequestMethod.GET)
	public ModelAndView goOfficeInsertForm() {
		System.out.println("컨트롤러들어옴");
		ModelAndView mav=new ModelAndView();
		List<AreaBean> arealist=systemconfigservice.getAreaList();
		mav.addObject("arealist",arealist);
		mav.setViewName("OfficeInsertForm");
		System.out.println("arealist.size()"+arealist.size());
		
		return mav;
	}
	
	@RequestMapping(value="InsertOffice.sc",method=RequestMethod.POST)
	public String OfficeInsertProc(@RequestParam(value="area_seq") String area_seq,
			@RequestParam(value="officename") String officename
			) {

		Map<String, String> map=new HashMap<String,String>();
		map.put("area_seq", area_seq);
		map.put("officename", officename);
		
		officeservice.InsertOffice(map);
		
		return "redirect:SystemConfig.sc";
	}
}
