package CurrentUser.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import CurrentUser.Model.CurrentUserBean;
import CurrentUser.Service.CurrentUserService;
import Paging.SwVersionManagementPaging;

@Controller
public class CurrrentUserListController {

	@Autowired
	CurrentUserService UserService;
	
	
	@RequestMapping(value="user.user")
	public ModelAndView UserList(
			@RequestParam(value="pageNumber", required=false) String textpageNumber
			 ,@RequestParam(value="swDate", required=false) String swDate
			 ,@RequestParam(value="areaname", required=false) String areaname
			) {
		
		if(swDate==null) {
			swDate="null";
		}
		
		
		
		Map<String, String> map=new HashMap<String,String>();
		map.put("swDate", swDate);
		map.put("areaname", areaname);
		ModelAndView mav = new ModelAndView();
		
		
		
		
	 	int totalCount = UserService.getTotalCount(map);
	 	SwVersionManagementPaging paging = new SwVersionManagementPaging(textpageNumber, totalCount, "user.user", swDate );
	 	List<CurrentUserBean> areaList = UserService.areaList();
		List<CurrentUserBean> UserList=UserService.CurretUserList(map,paging);
		
		mav.addObject("list", UserList);
		mav.addObject("arealist", areaList);
		mav.addObject("pageNumber", textpageNumber);
		mav.addObject("totalCount", totalCount);
		mav.addObject("paginghtml", paging.getPagingHtml());
		mav.addObject("beginrow",paging.getBeginRow());
		mav.addObject("endrow",paging.getEndRow());
		mav.addObject("areaname",areaname);
		mav.addObject("swDate",swDate);
		mav.setViewName("CurrentUserList");
		return mav;
	}
	
	
	
	
	
}
