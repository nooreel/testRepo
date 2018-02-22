package SystemConfig.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import SystemConfig.Model.AreaOfficeBean;
import SystemConfig.Model.AreaOfficeDepartmentBean;
import SystemConfig.Model.EmployeeBean;
import SystemConfig.Model.SystemConfigDao;
import User.Model.AreaBean;
import User.Model.OfficeBean;


@Controller
public class SystemConfigController {
	

	@Autowired
	SystemConfigDao systemconfigdao;
	
	@RequestMapping("SystemConfig.sc")
	public ModelAndView goSystemConfig() {
		ModelAndView mav=new ModelAndView();
		mav.setViewName("SystemConfig");
		
		List<AreaBean> arealist=systemconfigdao.getAreaList();
		mav.addObject("arealist",arealist);
		
		List<AreaOfficeBean> officelist=systemconfigdao.getOfficeList();
		mav.addObject("officelist",officelist);
		System.out.println(officelist.size()+"오피스리스트 사이즈");
		
		List<AreaOfficeDepartmentBean> departmentlist=systemconfigdao.getDepartmentList();
		mav.addObject("departmentlist",departmentlist);
		
		List<EmployeeBean> employeelist=systemconfigdao.getEmployeeList();
		mav.addObject("employeelist",employeelist);
		System.out.println("employee리스트 사이즈:"+employeelist.size());
		
		return mav;
	}
	
	
	
	
}
