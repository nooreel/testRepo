package windowsPatch.Model;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import Paging.WindowsPatchPaging;
import Paging.WindowsPatchUserPaging;

@Component
public class WindowsPatchDao {

	@Autowired
	SqlSessionTemplate sqlsessiontemplate;
	
	private final String namespace="WindowsMapper";
	
	public int getTotalService(Map<String, String> map) {
		int totalCount=sqlsessiontemplate.selectOne(namespace+".GetTotalCount",map);
		return totalCount;
		
	}
	
	public List<WindowsPatchBean> getWindowsPatchList(Map<String,String> map, WindowsPatchPaging paging){
		
		RowBounds rowbounds=new RowBounds(paging.getOffset(),paging.getLimit());
		List<WindowsPatchBean> list=sqlsessiontemplate.selectList(namespace+".SelectWindowsPatchList",map,rowbounds);
		return list;
	}
	
	public int getAjaxTotalCount(String swnumber) {
		int getAjaxTotalCount=sqlsessiontemplate.selectOne(namespace+".SelectAjaxTotalCount",swnumber);
		return getAjaxTotalCount;
	}
	
	public List<WindowsPatchUserBean> getWindowsPatchUserList(WindowsPatchUserPaging paging, String swnumber){
		RowBounds rowbounds=new RowBounds(paging.getOffset(),paging.getLimit());
		List<WindowsPatchUserBean> list=sqlsessiontemplate.selectList(namespace+".SelectWindowsPatchUserList",swnumber,rowbounds);
		return list;
	}
}
