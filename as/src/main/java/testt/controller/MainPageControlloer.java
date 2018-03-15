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
		System.out.println("��Ʈ�ѷ� ����");
		ModelAndView mav=new ModelAndView();
		mav.setViewName("index");
		
		//�ڻ���� Nclient ��ġ ����
		NclientAssetBean assetbean=mainpageservice.getNclientSetupInfoByAsset();
		mav.addObject("assetbean",assetbean);
		
		//���ڻ����Nclient ��ġ ����
		NclientAssetBean notassetbean=mainpageservice.getNclientSetupInfoByNotAsset();
		mav.addObject("notassetbean",notassetbean);
		
		//�����纰 ����Ʈ���� ��ġ ��Ȳ
		List<MakerSwChartBean> makerlist=mainpageservice.getMakerSwList();
		mav.addObject("makerlist",makerlist);
		
		return mav;
	}
	
}
