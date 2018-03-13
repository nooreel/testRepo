package CommercialSw.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import CommercialSw.Model.CommercialSwBean;
import CommercialSw.Service.CommercialSwService;
import Paging.CommercialSwPaging;
import Paging.OsPaging;
import os.Model.OsBean;

@Controller
public class CommercialSwController {

	@Autowired
	CommercialSwService commercialSwService;
	
	@RequestMapping(value="cswlist.csw")
	public ModelAndView CswListView(@RequestParam(value="fixedDate",required=false) String fixedDate,
			@RequestParam(value="pageNumber",required=false) String textPageNumber,
			@RequestParam(value="swnumber",required=false) String swnumber,
			@RequestParam(value="detailPageNumber",required=false) String detailTextPageNumber
			) {
		ModelAndView mav=new ModelAndView();
		mav.setViewName("Csw");
		
		if(fixedDate==null) {
			fixedDate="null";
		}
		
		Map<String, String> map=new HashMap<String,String>();
		map.put("fixedDate", fixedDate);
		int totalCount=commercialSwService.cswTotalCount(map);
		System.out.println(fixedDate+"csw 컨트롤러");

		CommercialSwPaging paging=new CommercialSwPaging(textPageNumber, totalCount, "cswlist.csw", fixedDate);
		
		
		List<CommercialSwBean> cswlist=commercialSwService.cswList(paging,map);
		
		mav.addObject("cswlist",cswlist);
		mav.addObject("paginghtml",paging.getPagingHtml());
		mav.addObject("fixedDate",fixedDate);
		mav.addObject("beginrow",paging.getBeginRow());
		mav.addObject("endrow",paging.getEndRow());
		mav.addObject("pageNumber",textPageNumber);
		mav.addObject("totalCount",totalCount);
		

		return mav;	
	}
}
