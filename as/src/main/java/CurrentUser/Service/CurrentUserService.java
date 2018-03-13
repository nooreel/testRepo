package CurrentUser.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import CurrentUser.Model.CurrentUserBean;
import Paging.SwVersionManagementPaging;


public interface CurrentUserService {

	public abstract List<CurrentUserBean> CurretUserList(Map<String, String> map, SwVersionManagementPaging paging);
	public abstract int getTotalCount(Map<String, String> map);
	public abstract List<CurrentUserBean> areaList();

}
