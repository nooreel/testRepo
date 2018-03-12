package os.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import Paging.OsDetailPaging;
import Paging.OsPaging;
import os.Model.OsBean;
import os.Model.OsDetailBean;
import os.Service.OsService;


@Controller
public class OsListController {

	@Autowired
	OsService osservice;
	
	
	@RequestMapping(value="OSlist.os")
	public ModelAndView OsListView(@RequestParam(value="fixedDate",required=false) String fixedDate,
			@RequestParam(value="pageNumber",required=false) String textPageNumber,
			@RequestParam(value="swnumber",required=false) String swnumber,
			@RequestParam(value="detailPageNumber",required=false) String detailTextPageNumber
			) {
		ModelAndView mav=new ModelAndView();
		mav.setViewName("OsList");
		
		if(fixedDate==null) {
			fixedDate="null";
		}
		
		Map<String, String> map=new HashMap<String,String>();
		map.put("fixedDate", fixedDate);
		int totalCount=osservice.getOsTotalCount(map);
		
		OsPaging paging=new OsPaging(textPageNumber, totalCount, "OSlist.os", fixedDate);
		
		List<OsBean> oslist=osservice.getOsList(paging,map);
		
		mav.addObject("oslist",oslist);
		mav.addObject("paginghtml",paging.getPagingHtml());
		mav.addObject("fixedDate",fixedDate);
		mav.addObject("beginrow",paging.getBeginRow());
		mav.addObject("endrow",paging.getEndRow());
		mav.addObject("pageNumber",textPageNumber);
		mav.addObject("totalCount",totalCount);
		
		if(swnumber!=null) {
			Map<String, String> detailmap=new HashMap<String,String>();
			detailmap.put("swnumber", swnumber);
			int detailTotalCount=osservice.getDetailTotalCount(detailmap);
			System.out.println("sysodetailTotalCOunt:"+detailTotalCount);
			
			
			OsDetailPaging detailPaging=new OsDetailPaging(detailTextPageNumber, detailTotalCount, "OSlist.os", fixedDate,swnumber);
			
			List<OsDetailBean> osdetaillist=osservice.getOsDetailList(detailPaging,detailmap);
			mav.addObject("osdetaillist",osdetaillist);
			mav.addObject("detailpaginghtml",detailPaging.getPagingHtml());
			mav.addObject("detailbeginrow",detailPaging.getBeginRow());
			mav.addObject("detailendrow",detailPaging.getEndRow());
			mav.addObject("detailpageNumber",detailTextPageNumber);
			mav.addObject("detailtotalCount",detailTotalCount);
			
		
			System.out.println("osdlist.size(): "+osdetaillist.size());
		}
		
		
		return mav;
	}
}
