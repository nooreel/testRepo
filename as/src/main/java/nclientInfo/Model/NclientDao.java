package nclientInfo.Model;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import Paging.NClientInfoByAreaPaging;
import Paging.NClientInfoPaging;

@Component
public class NclientDao {
	
	@Autowired
	SqlSessionTemplate sqlsessiontemplate;
	
	private final String namespace="NClientInfoMapper";
	
	
	public int getTotalCountNClientInfoByArea(Map<String, String> map) {
		int totalCount=sqlsessiontemplate.selectOne(namespace+".GetTotalCountNClientInfoByArea",map);
		return totalCount;
	}
	
	public List<NclientInfoByAreaBean> getNClientInfoByArea(NClientInfoPaging paging,Map<String,String> map){
		RowBounds rowbounds=new RowBounds(paging.getOffset(),paging.getLimit());
		List<NclientInfoByAreaBean> list=sqlsessiontemplate.selectList(namespace+".GetNClientInfoByArea",map,rowbounds);
		return list;
	}
	
	public int getAreaToDepartmentTotalCount(String area_seq) {
		int totalCount=sqlsessiontemplate.selectOne(namespace+".getAreaToDepartmentTotalCount",area_seq);
		return totalCount;
	}
	
	public List<NclientInfoByAreaToDepartmentBean> getAreaToDepartmentList(NClientInfoByAreaPaging paging,
			String area_seq){
		RowBounds rowbounds=new RowBounds(paging.getOffset(),paging.getLimit());
		List<NclientInfoByAreaToDepartmentBean> list=sqlsessiontemplate.selectList(namespace+".getAreaToDepartmentList",area_seq,rowbounds);
		return list;
	}
	
	public List<NclientInfoByAreaBean> exceltest(){
		List<NclientInfoByAreaBean> list=sqlsessiontemplate.selectList(namespace+".exceltest");
		return list;
	}
	
}
