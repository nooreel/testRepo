package SystemConfig.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import SystemConfig.Service.EmployeeService;

@Controller
public class EmployeeDeleteController {
	@Autowired
	EmployeeService employeeservice;
	
	@RequestMapping(value="EmployeeDelete.sc")
	public String DeleteEmployee(@RequestParam("employeenumber") String employeenumber){
		System.out.println("empnum:"+employeenumber);
		employeeservice.DeleteEmployee(employeenumber);
		
		return "redirect:SystemConfig.sc";
	}
}
