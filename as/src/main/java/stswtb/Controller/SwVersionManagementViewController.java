package stswtb.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import Paging.SwVersionManagementPaging;
import stswtb.Model.SwVersionManagementBean;
import stswtb.Service.StswtbService;

@Controller
public class SwVersionManagementViewController {

	@Autowired
	StswtbService stswtbservice;
	
	@RequestMapping(value="SwVersionManagement.stswtb")
	public ModelAndView SwVersionManagement(@RequestParam(value="pageNumber",required=false) String textpageNumber,
			@RequestParam(value="swDate",required=false) String swDate) {
		ModelAndView mav=new ModelAndView();
		mav.setViewName("SwVersionManagement");
		
		if(swDate==null) {
			swDate="null";
		}
		
		Map<String, String> map=new HashMap<String,String>();
		map.put("swDate", swDate);
		
		int totalCount=stswtbservice.getSwTotalCount(map);
		
		SwVersionManagementPaging paging=new SwVersionManagementPaging(textpageNumber, totalCount, "SwVersionManagement.stswtb", swDate);
		
		
		
		List<SwVersionManagementBean> swlist=stswtbservice.getSwVersionList(paging, map);
		mav.addObject("swlist",swlist);
		mav.addObject("paginghtml",paging.getPagingHtml());
		mav.addObject("swDate",swDate);
		mav.addObject("beginrow",paging.getBeginRow());
		mav.addObject("endrow",paging.getEndRow());
		mav.addObject("pageNumber",textpageNumber);
		mav.addObject("totalCount",totalCount);
		
		
		
		return mav;
	}
	
}
