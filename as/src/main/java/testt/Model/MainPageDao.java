package testt.Model;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import Paging.StswtbPaging;
import Paging.SwVersionManagementPaging;
import stswtb.Model.SwVersionManagementBean;
import sw.Model.SwBean;

@Component
public class MainPageDao {

	private final String namespace="MainpageMapper";
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	public List<ExplorerChartBean> getSwVersionCount() {
		 List<ExplorerChartBean> ecb = sqlSessionTemplate.selectList(namespace+".ExplorerChartTotal");
		System.out.println("cswdetailtotal dao ");
		return ecb;
	}
	
	
	public List<SwVersionManagementBean> getSwVersionList(Map<String, String> map){
		List<SwVersionManagementBean> list=sqlSessionTemplate.selectList(namespace+".getStandardSwList",map);
		return list;
	}
	
	public int getSwTotalCount(Map<String,String> map) {
		int totalCount=sqlSessionTemplate.selectOne(namespace+".getSwTotalCount",map);
		return totalCount;
		
	}
	
	
}
