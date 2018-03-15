package testt.controller;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import testt.Model.MakerSwChartBean;
import testt.Model.NclientAssetBean;
import testt.service.MainPageService;

@Controller
public class MainPageControlloer {
	@Autowired
	SqlSessionTemplate sqlsessiontemplate;
	
	@Autowired
	MainPageService mainpageservice;
	
	@RequestMapping("goMain.mainpage")
	public ModelAndView goMain() {
		System.out.println("컨트롤러 들어옴");
		ModelAndView mav=new ModelAndView();
		mav.setViewName("index");
		
		//자산장비 Nclient 설치 숫자
		NclientAssetBean assetbean=mainpageservice.getNclientSetupInfoByAsset();
		mav.addObject("assetbean",assetbean);
		
		//비자산장비Nclient 설치 숫자
		NclientAssetBean notassetbean=mainpageservice.getNclientSetupInfoByNotAsset();
		mav.addObject("notassetbean",notassetbean);
		
		//제조사별 소프트웨어 설치 현황
		List<MakerSwChartBean> makerlist=mainpageservice.getMakerSwList();
		mav.addObject("makerlist",makerlist);
		
		return mav;
	}
	
}
