package testt.Service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Paging.StswtbPaging;
import Paging.SwVersionManagementPaging;
import stswtb.Model.SwVersionManagementBean;
import sw.Model.SwBean;
import testt.Model.ExplorerChartBean;
import testt.Model.MainPageDao;

@Service
public class MainPageServicelmpl implements MainPageService{

	@Autowired
	MainPageDao mainPageDao;

	@Override
	public List<ExplorerChartBean> getSwVersionCountService() {
		List<ExplorerChartBean> ecb = mainPageDao.getSwVersionCount();
		return ecb;
	}


	@Override
	public List<SwVersionManagementBean> getSwVersionList(Map<String, String> map) {
		List<SwVersionManagementBean> list=mainPageDao.getSwVersionList(map);
		return list;
	}



	@Override
	public int getSwTotalCount(Map<String, String> map) {
		int totalCount=mainPageDao.getSwTotalCount(map);
		return totalCount;
	}
	
	
}
