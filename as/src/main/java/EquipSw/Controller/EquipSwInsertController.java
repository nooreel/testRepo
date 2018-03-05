package EquipSw.Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.plaf.synth.SynthSpinnerUI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import EquipSw.Model.EquipSwBean;
import EquipSw.Service.EquipSwService;
import sw.Model.SwBean;

@Controller
public class EquipSwInsertController {

	@Autowired
	EquipSwService equipswservice;
	
	
	@RequestMapping(value="EquipSwInsert.es",method=RequestMethod.GET)
	public ModelAndView goEquipSwInsertForm(
			@RequestParam(value="equipmentid",required=false) String equipmentid) {
		ModelAndView mav=new ModelAndView();
		mav.setViewName("EquipSwInsertForm");
		
		List<SwBean> standardswlist=equipswservice.getStandardSwList();
		List<SwBean> explorerlist=equipswservice.getExploreList();
		List<SwBean> oslist=equipswservice.getOsList();
		
		mav.addObject("standardswlist",standardswlist);
		mav.addObject("explorerlist",explorerlist);
		mav.addObject("oslist",oslist);
		mav.addObject("equipmentid",equipmentid);
		
		String sumSwname=equipswservice.getRecordByEquipmentid(equipmentid);
		mav.addObject("sumSwname",sumSwname);
		System.out.println(sumSwname);
		
		
		return mav;
	}

	@RequestMapping(value="EquipSwInsert.es",method=RequestMethod.POST)
	public ModelAndView EquipSwInserProc(EquipSwBean bean) {
		
		System.out.println(bean.getPatch_percent());
		System.out.println(bean.getSw().length);
		System.out.println(bean.getOs());
		System.out.println(bean.getEquipmentid());
		System.out.println(bean.getExplorer());
		
		
		equipswservice.equipSwRegist(bean);
		
		ModelAndView mav=new ModelAndView();
		mav.setViewName("redirect:EquipSwInsert.es?equipmentid="+bean.getEquipmentid());
		return mav;
	}
}

