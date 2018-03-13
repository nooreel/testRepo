package stswtb.Model;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import Paging.StswtbPaging;
import Paging.SwAllVersionPaging;
import Paging.SwVersionManagementPaging;
import sw.Model.SwBean;

@Component
public class StswtbDao {
	
	@Autowired
	SqlSessionTemplate sqlsessiontemplate;
	
	private static String namespace="StswtbMapper";
	
	public List<SwBean> getStandardSwList(StswtbPaging paging,Map<String, String> map){
		RowBounds rowbounds=new RowBounds(paging.getOffset(),paging.getLimit());
		List<SwBean> list=sqlsessiontemplate.selectList(namespace+".SelectStandardList",map,rowbounds);

		return list;
		
		
	}
	public int getTotalCount(Map<String, String> map) {
		int totalCount=sqlsessiontemplate.selectOne(namespace+".getTotalCount",map);
		return totalCount;
	}
	
	public List<SwVersionManagementBean> getSwVersionList(SwVersionManagementPaging paging,Map<String, String> map){
		RowBounds rowbounds=new RowBounds(paging.getOffset(),paging.getLimit());
		List<SwVersionManagementBean> list=sqlsessiontemplate.selectList(namespace+".getStandardSwList",map,rowbounds);
		return list;
	}
	
	public int getSwTotalCount(Map<String,String> map) {
		int totalCount=sqlsessiontemplate.selectOne(namespace+".getSwTotalCount",map);
		return totalCount;
		
	}
	
	public List<SwVersionManagementBean> getSwAllVersion(SwAllVersionPaging paging,Map<String, String> map){
		RowBounds rowbounds=new RowBounds(paging.getOffset(),paging.getLimit());
		List<SwVersionManagementBean> list=sqlsessiontemplate.selectList(namespace+".getSwAllVersion",map,rowbounds);
		return list;
	}
	
	public int getTotalCountFromSwAllVersion(Map<String, String> map) {
		int totalCount=sqlsessiontemplate.selectOne(namespace+".TotalCountFromSwAllVersion",map);
		return totalCount;
	}
}
