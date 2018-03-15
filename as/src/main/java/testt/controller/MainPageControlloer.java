package testt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import testt.Model.OsBean;
import testt.service.MainPageService;
import testt.service.MainpageServiceImpl;

@Controller
public class MainPageControlloer {
	
	@Autowired
	MainpageServiceImpl mainpageService;
	
	@RequestMapping("goMain.mainpage")
	public ModelAndView goMain() {
		System.out.println("��Ʈ�ѷ� ����");
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("index");
		List<OsBean> oslists = 
		mainpageService.OsDownload();
		OsBean bean = 
		mainpageService.WindowsPatch();
		List<OsBean> swlists  =
				mainpageService.SwDistribute();
		mav.addObject("oslists", oslists);
		mav.addObject("bean", bean);
		mav.addObject("swlists", swlists);
		System.out.println("����sw������Ȳ lists ������ ~~" +swlists.size());
		return mav;
	}
	
}
