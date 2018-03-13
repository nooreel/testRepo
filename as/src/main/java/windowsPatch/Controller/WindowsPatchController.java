package windowsPatch.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import Paging.WindowsPatchPaging;
import windowsPatch.Model.WindowsPatchBean;
import windowsPatch.Service.WindowsPatchService;

@Controller
public class WindowsPatchController {

	@Autowired
	WindowsPatchService windowspatchservice;
	
	@RequestMapping("WindowsPatch.wp")
	public ModelAndView goWindowsPatch(@RequestParam(value="pageNumber",required=false) String textPageNumber,
			@RequestParam(value="fixedDate",required=false) String fixedDate
			) {
		ModelAndView mav=new ModelAndView();
		mav.setViewName("WindowsPatch");
		
		if(fixedDate==null) {
			fixedDate="null";
		}
		
		Map<String,String> map=new HashMap<String, String>();
		map.put("fixedDate", fixedDate);
		
		int totalCount=windowspatchservice.getTotalService(map);
		
		WindowsPatchPaging paging=new WindowsPatchPaging(textPageNumber, totalCount, "WindowsPatch.wp", fixedDate);
		
		List<WindowsPatchBean> windowslist=windowspatchservice.getWindowsPatchList(map,paging);
		
		System.out.println("windowlist:"+windowslist.size());
		
		mav.addObject("windowslist",windowslist);
		mav.addObject("paginghtml",paging.getPagingHtml());
		mav.addObject("fixedDate",fixedDate);
		mav.addObject("beginrow",paging.getBeginRow());
		mav.addObject("endrow",paging.getEndRow());
		mav.addObject("pageNumber",textPageNumber);
		mav.addObject("totalCount",totalCount);
		
		
		for(int i=0;i<windowslist.size();i++) {
			System.out.println(windowslist.get(i).getSwname());
		}
		
		return mav;
	}
	
}
