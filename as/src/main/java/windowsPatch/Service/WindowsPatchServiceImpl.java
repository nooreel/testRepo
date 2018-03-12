package windowsPatch.Service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Paging.WindowsPatchPaging;
import Paging.WindowsPatchUserPaging;
import windowsPatch.Model.WindowsPatchBean;
import windowsPatch.Model.WindowsPatchDao;
import windowsPatch.Model.WindowsPatchUserBean;

@Service
public class WindowsPatchServiceImpl implements WindowsPatchService{

	@Autowired
	WindowsPatchDao windowspatchdao;
	
	@Override
	public int getTotalService(Map<String, String> map) {
		int totalCount=windowspatchdao.getTotalService(map);
		return totalCount;
	}

	@Override
	public List<WindowsPatchBean> getWindowsPatchList(Map<String, String> map, WindowsPatchPaging paging) {
		List<WindowsPatchBean> list=windowspatchdao.getWindowsPatchList(map, paging);
		return list;
	}

	@Override
		public int getAjaxTotalCount(String swnumber) {
		int ajaxTotalCount=windowspatchdao.getAjaxTotalCount(swnumber);
		return ajaxTotalCount;
	}

	@Override
	public List<WindowsPatchUserBean> getWindowsPatchUserList(WindowsPatchUserPaging paging, String swnumber) {
		List<WindowsPatchUserBean> list=windowspatchdao.getWindowsPatchUserList(paging, swnumber);
		return list;
	}

}
