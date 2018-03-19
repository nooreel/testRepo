package testt.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import stswtb.Model.SwVersionManagementBean;
import testt.Model.ExplorerChartBean;
import testt.Model.MainPageDao;
import testt.Model.MakerSwChartBean;
import testt.Model.NclientAssetBean;
import testt.Model.OsBean;

@Service
public class MainpageServiceImpl implements MainPageService {

	@Autowired
	MainPageDao mpdao;
	
	@Override
	public List<OsBean> OsDownload() {
		List<OsBean> oslists= mpdao.osdownloadList();
		
		return oslists;
	}

	@Override
	public OsBean WindowsPatch() {
		OsBean bean = 
				mpdao.windowsPatch();
		return bean;
	}

	@Override
	public List<OsBean> SwDistribute() {
		List<OsBean> swlists 
		= mpdao.SwDistribute();
		return swlists;
	}

	
	public NclientAssetBean getNclientSetupInfoByAsset(){
		NclientAssetBean bean=mpdao.getNclientSetupInfoByAsset();
		return bean;
	}

	@Override
	public NclientAssetBean getNclientSetupInfoByNotAsset() {
		NclientAssetBean bean=mpdao.getNclientSetupInfoByNotAsset();
		return bean;
	}

	@Override
	public List<MakerSwChartBean> getMakerSwList() {
		List<MakerSwChartBean> list=mpdao.getMakerSwList();
		return list;
	}
	@Override
	public List<ExplorerChartBean> getSwVersionCountService() {
		List<ExplorerChartBean> ecb = mpdao.getSwVersionCount();
		return ecb;
	}


	@Override
	public List<SwVersionManagementBean> getSwVersionList(Map<String, String> map) {
		List<SwVersionManagementBean> list=mpdao.getSwVersionList(map);
		return list;
	}



	@Override
	public int getSwTotalCount(Map<String, String> map) {
		int totalCount=mpdao.getSwTotalCount(map);
		return totalCount;
	}
	

}


