package testt.Model;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MainPageDao {

	@Autowired
	SqlSessionTemplate sqlsessiontemplate;
	
	private final String namespace="MainPageMapper";
	
	public NclientAssetBean getNclientSetupInfoByAsset(){
		NclientAssetBean assetbean=sqlsessiontemplate.selectOne(namespace+".NclientSetupInfoByAsset");
		return assetbean;
		
	}
	
	public NclientAssetBean getNclientSetupInfoByNotAsset() {
		NclientAssetBean bean=sqlsessiontemplate.selectOne(namespace+".NclientSetupInfoByNotAsset");
		return bean;
	}
	
	public List<MakerSwChartBean> getMakerSwList(){
		List<MakerSwChartBean> list=sqlsessiontemplate.selectList(namespace+".MakerSwList");
		return list;
	}
	
}
