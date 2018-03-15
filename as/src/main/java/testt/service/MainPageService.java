package testt.service;

import java.util.List;

import testt.Model.MakerSwChartBean;
import testt.Model.NclientAssetBean;

public interface MainPageService {
	public abstract NclientAssetBean getNclientSetupInfoByAsset();
	public abstract NclientAssetBean getNclientSetupInfoByNotAsset();
	public abstract List<MakerSwChartBean> getMakerSwList();
}
