package testt.service;

import java.util.List;

import testt.Model.OsBean;

public interface MainPageService {

	public abstract List<OsBean> OsDownload();
	public abstract OsBean WindowsPatch();
	public abstract List<OsBean> SwDistribute();
}
