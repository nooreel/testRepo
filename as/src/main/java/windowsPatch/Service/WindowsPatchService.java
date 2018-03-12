package windowsPatch.Service;

import java.util.List;
import java.util.Map;

import Paging.WindowsPatchPaging;
import Paging.WindowsPatchUserPaging;
import windowsPatch.Model.WindowsPatchBean;
import windowsPatch.Model.WindowsPatchUserBean;

public interface WindowsPatchService {

	public abstract int getTotalService(Map<String, String> map);
	public abstract List<WindowsPatchBean> getWindowsPatchList(Map<String,String> map, WindowsPatchPaging paging);
	public abstract int getAjaxTotalCount(String swnumber);
	public abstract List<WindowsPatchUserBean> getWindowsPatchUserList(WindowsPatchUserPaging paging,String swnumber);

}
