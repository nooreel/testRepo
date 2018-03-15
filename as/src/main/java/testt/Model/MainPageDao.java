package testt.Model;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
}
