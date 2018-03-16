package testt.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import Paging.StswtbPaging;
import Paging.SwVersionManagementPaging;
import stswtb.Model.SwVersionManagementBean;
import sw.Model.SwBean;
import testt.Model.ExplorerChartBean;
import testt.Service.MainPageService;

@Controller
public class MainPageControlloer {
	
	@Autowired
	MainPageService mainPageService;
	
	@RequestMapping("goMain.mainpage")
	public ModelAndView goMain() {
		System.out.println("컨트롤러 들어옴");
		ModelAndView mav = new ModelAndView();
		
		List<ExplorerChartBean> ecb = mainPageService.getSwVersionCountService();
		
		Map<String, String> map=new HashMap<String,String>();
		
		
		
		mav.addObject("ecb",ecb);
		System.out.println("ecb.size():"+ecb.size());
		
		int totalCount=mainPageService.getSwTotalCount(map);
		
		
		List<SwVersionManagementBean> swlist=mainPageService.getSwVersionList(map);
		mav.addObject("swlist",swlist);
		mav.addObject("totalCount",totalCount);
		
		mav.setViewName("index");
		
		return mav;
		
		

	}
	
	
	
}
