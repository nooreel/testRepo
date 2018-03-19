package nclientInfo.Controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import nclientInfo.Model.NclientInfoByAreaBean;
import nclientInfo.Service.NclientInfoService;


@Controller
public class NclientInfoDownload {

	@Autowired
	NclientInfoService nclientinfoservice;
	
	@RequestMapping("excelDownload.ni")
	public ModelAndView excelTransForm(HttpServletResponse response) {
		System.out.println("¿¢¼¿ ´Ù¿î·Îµå µé¾î¿È");
		List<NclientInfoByAreaBean> list=nclientinfoservice.exceltest();
		//setViewName, addObject//
		ModelAndView mav=new ModelAndView("excelView","list",list);
		
		
		
		return mav;

		
		
	}




}
