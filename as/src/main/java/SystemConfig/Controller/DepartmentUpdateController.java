package SystemConfig.Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import SystemConfig.Model.AreaOfficeDepartmentBean;
import SystemConfig.Model.DepartmentDao;
import SystemConfig.Model.SystemConfigDao;
import SystemConfig.Service.DepartmentService;
import SystemConfig.Service.SystemConfigService;
import User.Model.AreaBean;

@Controller
public class DepartmentUpdateController {

	@Autowired
	DepartmentService departmentservice;
	
	@Autowired
	SystemConfigService systemconfigservice;
	
	@RequestMapping(value="UpdateDepartment.sc",method=RequestMethod.GET)
	public ModelAndView goDepartmentUpdateForm(@RequestParam("department_seq") String department_seq) {
		ModelAndView mav=new ModelAndView();
		AreaOfficeDepartmentBean bean=departmentservice.getDepartmentRecord(department_seq);
		mav.addObject("bean",bean);
		System.out.println(bean.getArea_seq());
		
		List<AreaBean> arealist=systemconfigservice.getAreaList();
		mav.addObject("arealist",arealist);
		mav.setViewName("DepartmentUpdateForm");
		
		return mav;
	}
	
	@RequestMapping(value="UpdateDepartment.sc",method=RequestMethod.POST)
	public String UpdateDepartmentProc(HttpServletRequest request) {
		AreaOfficeDepartmentBean bean=new AreaOfficeDepartmentBean();
		bean.setArea_seq(Integer.parseInt(request.getParameter("area_seq")));
		bean.setOffice_seq(Integer.parseInt(request.getParameter("office_seq")));
		bean.setDepartment_seq(Integer.parseInt(request.getParameter("department_seq")));
		bean.setDepartmentname(request.getParameter("departmentname"));
		
		departmentservice.UpdateDepartment(bean);
		
		return "redirect:SystemConfig.sc";
	}
	
}
