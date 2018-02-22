package SystemConfig.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import SystemConfig.Model.AreaOfficeBean;
import SystemConfig.Model.AreaOfficeDepartmentBean;
import SystemConfig.Model.DepartmentDao;
import SystemConfig.Model.SystemConfigDao;
import User.Model.AreaBean;

@Controller
public class DepartmentInsertController {
	
	@Autowired
	SystemConfigDao systemconfigdao;
	
	@Autowired
	DepartmentDao departmentdao;

	@RequestMapping(value="InsertDepartment.sc",method=RequestMethod.GET)
	public ModelAndView goInsertDepartmentForm() {
		ModelAndView mav=new ModelAndView();
		
		List<AreaBean> arealist=systemconfigdao.getAreaList();
		mav.addObject("arealist",arealist);
		
		mav.setViewName("DepartmentInsertForm");
		return mav;
	}
	
	@RequestMapping(value="InsertDepartment.sc",method=RequestMethod.POST)
	public String InsertDepartmentProc(HttpServletRequest request) {
		
		String office_seq=request.getParameter("office_seq");
		String departmentname=request.getParameter("departmentname");
		Map<String, String> map=new HashMap<String,String>();
		AreaOfficeDepartmentBean bean=new AreaOfficeDepartmentBean();
		bean.setOffice_seq(Integer.parseInt(office_seq));
		bean.setDepartmentname(departmentname);
		
		departmentdao.InsertDepartment(bean);
		
		return "redirect:SystemConfig.sc";
	}
	
}
