package testt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import testt.Model.MainPageDao;
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

}


