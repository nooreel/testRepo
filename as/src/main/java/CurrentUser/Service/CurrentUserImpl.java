package CurrentUser.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import CurrentUser.Model.CurrentUserBean;
import CurrentUser.Model.CurrentUserDao;
import Paging.SwVersionManagementPaging;

@Service
public class CurrentUserImpl implements CurrentUserService{

	@Autowired
	CurrentUserDao cusDao;
	
	@Override
	public List<CurrentUserBean> CurretUserList(Map<String, String> map, SwVersionManagementPaging paging) {
		List<CurrentUserBean> lists 
		= cusDao.getUserList(map, paging);
		
		return lists;
	}

	

	@Override
	public List<CurrentUserBean> areaList() {
		List<CurrentUserBean> areaList =  cusDao.getAreaList();
		return areaList;
	}
	
	@Override
	public int getTotalCount(Map<String, String> map) {
		int totalCount =
				cusDao.getTotalCount(map);
		return totalCount;
	}


}
