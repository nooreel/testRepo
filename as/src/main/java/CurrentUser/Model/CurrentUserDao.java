package CurrentUser.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import Paging.SwVersionManagementPaging;

@Component
public class CurrentUserDao {

	@Autowired
	SqlSessionTemplate sqlsessionTemplate;
	
	private static String namespace="CurrentUserMapper";

	public List<CurrentUserBean> getUserList(Map<String, String> map,SwVersionManagementPaging paging){
		
		RowBounds rowbounds = new RowBounds(paging.getOffset(),paging.getLimit());
		List<CurrentUserBean> lists
		= sqlsessionTemplate.selectList(namespace+".userList", map, rowbounds);
		return lists;
	}
	
	public List<CurrentUserBean> getAreaList(){
		
		List<CurrentUserBean> areaList
		=sqlsessionTemplate.selectList(namespace +".areaList");
		return areaList;
	}

	
	public int getTotalCount(Map<String, String> map) {
		int totalcount =0;
		totalcount =
				sqlsessionTemplate.selectOne(namespace+".getTotalCount" , map);

		return totalcount;
		
	}
}
