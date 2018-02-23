package sw.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import sw.Model.SwBean;
import sw.Service.SwService;


@Controller
public class SwRegistController {

	@Autowired
	SwService swservice;
	
	
	@RequestMapping(value="SwRegist.sw")
	public String goSwRegisterForm() {
		return "swRegisterForm";
	}
	
	@RequestMapping("InsertSw.sw")
	public String InsertSw(SwBean bean) {
		System.out.println(bean.getSwname());
		System.out.println(bean.getSwversion());
		System.out.println(bean.getSwtype());
		System.out.println(bean.getBit());
		System.out.println(bean.getMaker());
		System.out.println(bean.getUsed());
		System.out.println(bean.getQuantity());
		
		swservice.swInsert(bean);
		
		return "swRegisterForm";
	}
	
	
	
	
}
