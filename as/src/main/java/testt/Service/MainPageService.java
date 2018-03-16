package testt.Service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import Paging.StswtbPaging;
import Paging.SwVersionManagementPaging;
import stswtb.Model.SwVersionManagementBean;
import sw.Model.SwBean;
import testt.Model.ExplorerChartBean;

@Service
public interface MainPageService {

	public abstract List<ExplorerChartBean> getSwVersionCountService();
	public abstract List<SwVersionManagementBean> getSwVersionList(Map<String, String> map);
	public abstract int getSwTotalCount(Map<String,String> map);
		
	
	
}
