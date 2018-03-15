package testt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import testt.Model.MainPageDao;
import testt.Model.MakerSwChartBean;
import testt.Model.NclientAssetBean;

@Service
public class MainPageServiceImpl implements MainPageService{

	@Autowired
	MainPageDao mainpagedao;
	
	public NclientAssetBean getNclientSetupInfoByAsset(){
		NclientAssetBean bean=mainpagedao.getNclientSetupInfoByAsset();
		return bean;
	}

	@Override
	public NclientAssetBean getNclientSetupInfoByNotAsset() {
		NclientAssetBean bean=mainpagedao.getNclientSetupInfoByNotAsset();
		return bean;
	}

	@Override
	public List<MakerSwChartBean> getMakerSwList() {
		List<MakerSwChartBean> list=mainpagedao.getMakerSwList();
		return list;
	}
}
