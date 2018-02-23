package SystemConfig.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import SystemConfig.Service.DepartmentService;

@Controller
public class DepartmentDeleteController {

	@Autowired
	DepartmentService departmentservice;
	
	@RequestMapping("deleteDepartment.sc")
	public String DeleteDepartmentProc(@RequestParam("department_seq") String department_seq) {
		
		departmentservice.deleteDepartment(department_seq);
		
		return "redirect:SystemConfig.sc";
	}
	
}
