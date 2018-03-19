package testt.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import stswtb.Model.SwVersionManagementBean;
import testt.Model.ExplorerChartBean;
import testt.Model.MakerSwChartBean;
import testt.Model.NclientAssetBean;
import testt.Model.OsBean;
import testt.service.MainPageService;
import testt.service.MainpageServiceImpl;

@Controller
public class MainPageControlloer {
	
	@Autowired
	MainpageServiceImpl mainpageService;
	
	@RequestMapping("goMain.mainpage")
	public ModelAndView goMain() {
		System.out.println("��Ʈ�ѷ� ����");
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("index");
		List<OsBean> oslists = 
		mainpageService.OsDownload();
		OsBean bean = 
		mainpageService.WindowsPatch();
		List<OsBean> swlists  =
				mainpageService.SwDistribute();
		mav.addObject("oslists", oslists);
		mav.addObject("bean", bean);
		mav.addObject("swlists", swlists);
		System.out.println("����sw������Ȳ lists ������ ~~" +swlists.size());
		//�ڻ���� Nclient ��ġ ����
				NclientAssetBean assetbean=mainpageService.getNclientSetupInfoByAsset();
				mav.addObject("assetbean",assetbean);
				
				//���ڻ����Nclient ��ġ ����
				NclientAssetBean notassetbean=mainpageService.getNclientSetupInfoByNotAsset();
				mav.addObject("notassetbean",notassetbean);
				
				//�����纰 ����Ʈ���� ��ġ ��Ȳ
				List<MakerSwChartBean> makerlist=mainpageService.getMakerSwList();
				mav.addObject("makerlist",makerlist);
				

				List<ExplorerChartBean> ecb = mainpageService.getSwVersionCountService();
				
				Map<String, String> map=new HashMap<String,String>();
				
				
				
				System.out.println("ecb.size():"+ecb.size());
				
				int totalCount=mainpageService.getSwTotalCount(map);
				
				
				mav.addObject("ecb",ecb);
				List<SwVersionManagementBean> swlist=mainpageService.getSwVersionList(map);
				mav.addObject("swlist",swlist);
				mav.addObject("totalCount",totalCount);
		
		return mav;
	}
	
}
