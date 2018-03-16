package Explorer.Model;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import Paging.SwAllVersionPaging;

@Component
public class ExplorerDao {

	@Autowired
	SqlSessionTemplate sqlsessiontemplate;
	
	private static String namespace="ExplorerMapper";
	

	
	public List<ExplorerBean> getExList(Map<String,String> map){
		List<ExplorerBean> lists =
		sqlsessiontemplate.selectList(namespace+".getExList", map);
		return lists;
	}
	
	public int getTotalCount(Map<String,String> map) {
		int totalCount= 0;
		totalCount = sqlsessiontemplate.selectOne(namespace+".getTotalCount", map);
		return totalCount;
		
	}

	public int getDetailTotalCount(int swnumber) {
		int totalCount= 0;
		totalCount = sqlsessiontemplate.selectOne(namespace+".getDetailTotalCount", swnumber);
		return totalCount;
	}
	
	public List<ExplorerDetailBean> getExDetailList(int swnumber,SwAllVersionPaging paging){
		RowBounds rowbounds=new RowBounds(paging.getOffset(),paging.getLimit());
		List<ExplorerDetailBean> lists =
				sqlsessiontemplate.selectList(namespace+".getExDetailList", swnumber,rowbounds);
				return lists;
	}
}
