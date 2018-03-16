package Explorer.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import Explorer.Model.ExplorerBean;
import Explorer.Service.ExplorerService;
import Paging.StswtbPaging;

@Controller
public class ExplorerListController {

	
 @Autowired
 ExplorerService ExService;
 
 @RequestMapping(value="explorer.exp")
 public ModelAndView exList(
		 @RequestParam(value="pageNumber",required=false) String textpageNumber
		 ,@RequestParam(value="swDate", required=false) String swDate
		 
		 ){
	 
	 if(swDate==null) {
			swDate="null";
		}
		
		Map<String, String> map=new HashMap<String,String>();
		map.put("swDate", swDate);
		ModelAndView mav = new ModelAndView();

		
	 	int totalCount = ExService.getTotalCount(map);
	 	StswtbPaging paging = new StswtbPaging(textpageNumber, totalCount, "explorer.exp", null );
	 	
		List<ExplorerBean> exlist=ExService.exList(map);
		mav.addObject("list", exlist);
		mav.addObject("pageNumber", textpageNumber);
		mav.addObject("totalCount", totalCount);
		mav.addObject("paginghtml", paging.getPagingHtml());
		mav.addObject("beginrow",paging.getBeginRow());
		mav.addObject("endrow",paging.getEndRow());
		mav.setViewName("exList");
		return mav;
 }
	
}
