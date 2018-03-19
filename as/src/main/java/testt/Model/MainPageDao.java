package testt.Model;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import stswtb.Model.SwVersionManagementBean;

@Component
public class MainPageDao {

	@Autowired
	SqlSessionTemplate sqlsessionTemplate;
	
	private static String namespace="MainPageMapper";
	
	public List<OsBean> osdownloadList(){
		List<OsBean> oslists = sqlsessionTemplate.selectList(namespace+".oslist");
		return oslists;
		
	}
	
	public OsBean windowsPatch() {
		OsBean bean = sqlsessionTemplate.selectOne(namespace+".windowspatch");
		return bean;
		
	}
	
	public List<OsBean> SwDistribute() {
		List<OsBean> swlists = sqlsessionTemplate.selectList(namespace+".swdistribute");
		return swlists;
	}
	
	
	public NclientAssetBean getNclientSetupInfoByAsset(){
		NclientAssetBean assetbean=sqlsessionTemplate.selectOne(namespace+".NclientSetupInfoByAsset");
		return assetbean;
		
	}
	
	public NclientAssetBean getNclientSetupInfoByNotAsset() {
		NclientAssetBean bean=sqlsessionTemplate.selectOne(namespace+".NclientSetupInfoByNotAsset");
		return bean;
	}
	
	public List<MakerSwChartBean> getMakerSwList(){
		List<MakerSwChartBean> list=sqlsessionTemplate.selectList(namespace+".MakerSwList");
		return list;
	}
	
	public List<ExplorerChartBean> getSwVersionCount() {
		 List<ExplorerChartBean> ecb = sqlsessionTemplate.selectList(namespace+".ExplorerChartTotal");
		System.out.println("cswdetailtotal dao ");
		return ecb;
	}
	
	
	public List<SwVersionManagementBean> getSwVersionList(Map<String, String> map){
		List<SwVersionManagementBean> list=sqlsessionTemplate.selectList(namespace+".getStandardSwList",map);
		return list;
	}
	
	public int getSwTotalCount(Map<String,String> map) {
		int totalCount=sqlsessionTemplate.selectOne(namespace+".getSwTotalCount",map);
		return totalCount;
		
	}
}
