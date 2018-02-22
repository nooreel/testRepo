package SystemConfig.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import SystemConfig.Model.OfficeDao;

@Controller
public class OfficeDeleteController {
	
	@Autowired
	OfficeDao officedao;
	
	@RequestMapping(value="DeleteOffice.sc",method=RequestMethod.GET)
	public ModelAndView goOfficeUpdateForm(@RequestParam("office_seq") String office_seq,
		HttpServletResponse response) {
		System.out.println("µô¸®Æ® ÄÁÆ®·Ñ·¯ µé¾î¿È");
		ModelAndView mav=new ModelAndView();

		officedao.DeleteOffice(office_seq);
		mav.setViewName("redirect:SystemConfig.sc");
		
		return mav;
	
	}
}
