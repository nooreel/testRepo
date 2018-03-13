package CurrentUser.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import CurrentUser.Model.CurrentUserBean;
import CurrentUser.Service.CurrentUserService;
import Paging.NClientInfoByAreaPaging;
import Paging.SwVersionManagementPaging;

@Controller
public class CurrentUserDetailViewController {
	
	
	@Autowired
	CurrentUserService UserService;
	
	@ResponseBody
	@RequestMapping(value="detailUser.user")
	public  Map<String, Object> detailUser(
			@RequestParam(value="department_seq") String department_seq2,
			@RequestParam(value="pageNumber",required=false) String textPageNumber) {
		
		System.out.println("들어와들어와 department_seq?" + department_seq2);
		
		int  department_seq = Integer.parseInt(department_seq2);
		int totalCount = UserService.getDetailTotalCount(department_seq);
		NClientInfoByAreaPaging paging = new NClientInfoByAreaPaging(textPageNumber, totalCount, "detailUser.user", null, department_seq2);
		List<CurrentUserBean> list = UserService.CurrentUserDetailList(department_seq, paging);
		
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("list", list);
		map.put("paging", paging);
		
		return map;
		
		
		
	}
}
