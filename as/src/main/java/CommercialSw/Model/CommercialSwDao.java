package CommercialSw.Model;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import Paging.CommercialSwPaging;
import Paging.OsPaging;
import os.Model.OsBean;

@Component
public class CommercialSwDao {

	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	private final String namespace="CommercialSwMapper";
	
public List<CommercialSwBean> cswList(CommercialSwPaging paging,Map<String,String> map){
		
		RowBounds rowbounds=new RowBounds(paging.getOffset(),paging.getLimit());
		List<CommercialSwBean> list=sqlSessionTemplate.selectList(namespace+".cswGetList",map,rowbounds);
		System.out.println("cswlist dao");
		
		return list;
	}
	
	public int cswTotalCount(Map<String, String> map) {	
		System.out.println("map: "+map.get("fixedDate"));
		int count=sqlSessionTemplate.selectOne(namespace+".cswTotalCount",map);
		
		return count;
	}
	
	
	
}
