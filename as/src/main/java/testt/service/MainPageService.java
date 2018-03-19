package testt.service;

import java.util.List;
import java.util.Map;

import stswtb.Model.SwVersionManagementBean;
import testt.Model.ExplorerChartBean;
import testt.Model.MakerSwChartBean;
import testt.Model.NclientAssetBean;
import testt.Model.OsBean;

public interface MainPageService {

	public abstract List<OsBean> OsDownload();
	public abstract OsBean WindowsPatch();
	public abstract List<OsBean> SwDistribute();
	public abstract NclientAssetBean getNclientSetupInfoByAsset();
	public abstract NclientAssetBean getNclientSetupInfoByNotAsset();
	public abstract List<MakerSwChartBean> getMakerSwList();
	public abstract List<ExplorerChartBean> getSwVersionCountService();
	public abstract List<SwVersionManagementBean> getSwVersionList(Map<String, String> map);
	public abstract int getSwTotalCount(Map<String,String> map);
	
}
