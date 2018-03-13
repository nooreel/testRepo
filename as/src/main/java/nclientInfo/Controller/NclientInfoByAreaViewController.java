package nclientInfo.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import Paging.NClientInfoPaging;
import nclientInfo.Model.NclientInfoByAreaBean;
import nclientInfo.Service.NclientInfoService;

@Controller
public class NclientInfoByAreaViewController{

	@Autowired
	NclientInfoService nclientinfoservice;
	
	@RequestMapping("NclientInfoByArea.ni")
	public ModelAndView goNClientInfoByArea(
			@RequestParam(value="pageNumber",required=false) String textPageNumber,
			@RequestParam(value="fixedDate",required=false) String fixedDate
			) {
		System.out.println("nClient컨트롤러 들어옴");
		ModelAndView mav=new ModelAndView();
		mav.setViewName("NClientInfo");
		
		if(fixedDate==null) {
			fixedDate="null";
		}
		
		Map<String, String> map=new HashMap<String,String>();
		map.put("fixedDate", fixedDate);
		
		int totalCount=nclientinfoservice.getTotalCountNClientInfoByArea(map);
		
		System.out.println("totalCount:"+totalCount);
		
		
		NClientInfoPaging paging=new NClientInfoPaging(textPageNumber, totalCount, "NclientInfoByArea.ni", fixedDate);
		
		List<NclientInfoByAreaBean> nclientinfolist=nclientinfoservice.getNClientInfoByArea(paging, map);
		
		mav.addObject("nclientinfolist",nclientinfolist);
		mav.addObject("paginghtml",paging.getPagingHtml());
		mav.addObject("fixedDate",fixedDate);
		mav.addObject("beginrow",paging.getBeginRow());
		mav.addObject("endrow",paging.getEndRow());
		mav.addObject("pageNumber",textPageNumber);
		mav.addObject("totalCount",totalCount);
		
		
		
		
		
		return mav;
	}
}
