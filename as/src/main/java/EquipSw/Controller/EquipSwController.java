package EquipSw.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import EquipSw.Service.EquipSwService;
import Equipment.Model.EquipmentBean;
import Paging.EqPaging;
import Paging.SwPaging;
import sw.Model.SwBean;

@Controller
public class EquipSwController {
	
	@Autowired
	EquipSwService EquipSwservice;
	
	@RequestMapping(value="EquipSwConfig.es")
	public ModelAndView goEquipSwConfig(
			@RequestParam(value="pageNumber",required=false) String textpageNumber,
			@RequestParam(value="whatColumn",required=false) String whatColumn,
			@RequestParam(value="keyword",required=false) String keyword,
			@RequestParam(value="eqpageNumber",required=false) String eptextpageNumber,
			@RequestParam(value="eqwhatColumn",required=false) String eqwhatColumn,
			@RequestParam(value="eqkeyword",required=false) String eqkeyword
			) {
		
		ModelAndView mav=new ModelAndView();
		mav.setViewName("EquipSwConfig");
		
		/*SW*/
		Map<String, String> map=new HashMap<String,String>();
		map.put("whatColumn",whatColumn);
		map.put("keyword","%"+keyword+"%");
		
		int totalCount=EquipSwservice.getSwListSize(map);
		SwPaging swpaging=new SwPaging(textpageNumber, totalCount,"EquipSwConfig.es",map.get("whatColumn"),keyword);
		
		List<SwBean> swlist=EquipSwservice.getSwList(swpaging,map);
		
		System.out.println("keyword:"+keyword);
		System.out.println("keyword:"+map.get("keyword"));
		mav.addObject("swlist",swlist);
		mav.addObject("swpagehtml",swpaging.getPagingHtml());
		mav.addObject("pageNumber",textpageNumber);
		mav.addObject("whatColumn",whatColumn);
		mav.addObject("keyword",keyword);
		
		
		
		/*¿Â∫Ò*/
		Map<String, String> eqmap=new HashMap<String,String>();
		eqmap.put("whatColumn", eqwhatColumn);
		eqmap.put("keyword", "%"+eqkeyword+"%");
		
		int eqtotalCount=EquipSwservice.getEqListSize(eqmap);
		EqPaging eqpaging=new EqPaging(eptextpageNumber, eqtotalCount, "EquipSwConfig.es", eqmap.get("whatColumn"), eqkeyword);
		List<EquipmentBean> eqlist=EquipSwservice.getEqList(eqpaging, eqmap);
		
		mav.addObject("eqlist",eqlist);
		mav.addObject("eqpagehtml",eqpaging.getPagingHtml());
		mav.addObject("eqpageNumber",eptextpageNumber);
		mav.addObject("eqwhatColumn",eqwhatColumn);
		mav.addObject("eqkeyword",eqkeyword);
		
		return mav;
	}
}
