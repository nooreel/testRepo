package stswtb.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import Paging.StswtbPaging;
import stswtb.Service.StswtbService;
import sw.Model.SwBean;

@Controller
public class StswtbViewController {

	@Autowired
	StswtbService stswtbservice;
	
	@RequestMapping("StandardSwTable.stswtb")
	public ModelAndView goStandardSwTable(
			@RequestParam(value="pageNumber",required=false) String textpageNumber,
			@RequestParam(value="swDate",required=false) String swDate
			) {
		ModelAndView mav=new ModelAndView();
		mav.setViewName("StandardSwTable");
		
		if(swDate==null) {
			swDate="null";
		}
			
		System.out.println("swDate: "+swDate);
		
		Map<String, String> map=new HashMap<String,String>();
		map.put("swDate", swDate);
		
		int totalCount=stswtbservice.getTotalCount(map);
		StswtbPaging paging=new StswtbPaging(textpageNumber, totalCount, "StandardSwTable.stswtb",swDate);
		
		
		List<SwBean> swlist=stswtbservice.getStandardSwList(paging,map);
		mav.addObject("swlist",swlist);
		
		mav.addObject("totalCount",totalCount);
		mav.addObject("pageNumber",textpageNumber);
		mav.addObject("totalCount",totalCount);
		mav.addObject("paginghtml",paging.getPagingHtml());
		mav.addObject("swDate",swDate);
		mav.addObject("beginrow",paging.getBeginRow());
		mav.addObject("endrow",paging.getEndRow());
		
		
		return mav;
	
	}
	
}
