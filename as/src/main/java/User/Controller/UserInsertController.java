package User.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import User.Model.AreaBean;
import User.Model.DepartmentBean;
import User.Model.EmployeeBean;
import User.Model.OfficeBean;

import User.Service.UserService;

@Controller
public class UserInsertController {
	
	@Autowired
	UserService userservice;
	
	
	@RequestMapping(value="UserInsertForm.us",method=RequestMethod.GET)
	public ModelAndView UserInsertForm() {
		ModelAndView mav=new ModelAndView();
		mav.setViewName("UserInsertForm");
		
		List<AreaBean> areaList=userservice.getAreaList();
		mav.addObject("areaList", areaList);

		return mav;
	}
	
	@RequestMapping("getOfficeList.us")
	public void getOfficeList(HttpServletRequest request,HttpServletResponse response) {
		response.setContentType("text/html;charset=UTF-8");
		String area_seq=request.getParameter("area_seq");
		List<OfficeBean> officeList=userservice.getOfficeList(area_seq);
		
		try {
			PrintWriter out=response.getWriter();
			if(officeList.size()!=0) {
				for(int i=0;i<officeList.size();i++) {
					out.print("<option value='"+officeList.get(i).getOffice_seq()+"'>"+officeList.get(i).getOfficename()+"</option>");
				}
			}else {
				out.print("<option value='default'>지점없음</option>");
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	@RequestMapping("getDepartmentList.us")
	public void getDepartmentList(HttpServletRequest request,HttpServletResponse response) {
		response.setContentType("text/html;charset=UTF-8");
		String office_seq=request.getParameter("office_seq");
		List<DepartmentBean> departmentList=userservice.getDepartmentList(office_seq);
		
		try {
			PrintWriter out=response.getWriter();
			if(departmentList.size()!=0) {
				for(int i=0;i<departmentList.size();i++) {
					out.print("<option value='"+departmentList.get(i).getDepartment_seq()+"'>"+departmentList.get(i).getDepartmentname()+"</option>");
				}
			}else {
				out.print("<option value='default'>부서없음</option>");
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	@RequestMapping("employeeNumberCheck.us")
	public void employeeNumberCheck(HttpServletRequest request,HttpServletResponse response) {
		response.setContentType("text/html;charset=UTF-8");
		String employeenumber=request.getParameter("employeenumber");
		String result=userservice.employeeNumberCheck(employeenumber);
		System.out.println("result: "+result);
		try {
			PrintWriter out=response.getWriter();
			out.print(result);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@RequestMapping(value="UserInsertForm.us",method=RequestMethod.POST)
	public void UserInsertProc(EmployeeBean eb,HttpServletResponse response) {
		System.out.println(eb.getArea_seq());
		System.out.println(eb.getOffice_seq());
		System.out.println(eb.getDepartment_seq());
		System.out.println(eb.getEmployeenumber());
		System.out.println(eb.getPassword());
		System.out.println(eb.getBirth());
		System.out.println(eb.getEmployeename());
		System.out.println(eb.getEmployeeposition());
		System.out.println(eb.getPrivilege());
		System.out.println(eb.getEmail());
		
		int count=userservice.insertUser(eb);
		
		response.setContentType("text/html;charset=UTF-8");
		try {
			PrintWriter out=response.getWriter();
			if(count==1) {
				out.println("<script>");
				out.println("alert('사용자가 등록되었습니다');");
				out.println("location.href='goMain.mainpage';");
				out.println("</script>");
			}
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
}
