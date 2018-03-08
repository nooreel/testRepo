package os.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import os.Model.OsBean;
import os.Service.OsService;


@Controller
public class OsListController {

	@Autowired
	OsService osservice;
	
	
	@RequestMapping(value="OSlist.os")
	public ModelAndView OsListView() {
		ModelAndView mav=new ModelAndView();
		mav.setViewName("OsList");
		
		List<OsBean> oslist=osservice.getOsList();
		
		
		return mav;
	}
}
