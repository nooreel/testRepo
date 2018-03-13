package os.Model;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import Paging.OsDetailPaging;
import Paging.OsPaging;

@Component
public class OsDao {

	@Autowired
	SqlSessionTemplate sqlsessiontemplate;
	
	private final String namespace="OsMapper";
	
	public List<OsBean> getOsList(OsPaging paging,Map<String,String> map){
		
		RowBounds rowbounds=new RowBounds(paging.getOffset(),paging.getLimit());
		List<OsBean> list=sqlsessiontemplate.selectList(namespace+".SelectOsList",map,rowbounds);
		return list;
	}
	
	public int getOsTotalCount(Map<String, String> map) {	
		int count=sqlsessiontemplate.selectOne(namespace+".GetOsTotalCount",map);
		return count;
	}
	
	public List<OsDetailBean> getOsDetailList(OsDetailPaging detailPaging, Map<String, String> detailmap){
		RowBounds rowbounds=new RowBounds(detailPaging.getOffset(),detailPaging.getLimit());
		List<OsDetailBean> list=sqlsessiontemplate.selectList(namespace+".SelectOsDetailList",detailmap,rowbounds);
		return list;
	}
	
	public int getDetailTotalCount(Map<String,String >detailmap) {
		int detailTotalCount=sqlsessiontemplate.selectOne(namespace+".GetDetailTotalCount",detailmap);
		return detailTotalCount;
	}
	
}
