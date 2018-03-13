package CurrentUser.Service;

import java.util.List;
import java.util.Map;

import CurrentUser.Model.CurrentUserBean;
import Paging.NClientInfoByAreaPaging;
import Paging.SwVersionManagementPaging;


public interface CurrentUserService {

	public abstract List<CurrentUserBean> CurretUserList(Map<String, String> map, SwVersionManagementPaging paging);
	public abstract int getTotalCount(Map<String, String> map);
	public abstract List<CurrentUserBean> areaList();
	public abstract int getDetailTotalCount(int department_seq);
	public abstract List<CurrentUserBean> CurrentUserDetailList(int department_seq, NClientInfoByAreaPaging paging);
}
