package SystemConfig.Model;

import java.util.HashMap;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AreaDao {

	@Autowired
	SqlSessionTemplate sqlsessiontemplate;
	private final String namespace="AreaMapper";
	
	public int insertArea(String areaname) {
		System.out.println("areaname:"+areaname);
		int result=sqlsessiontemplate.selectOne(namespace+".ChkAreaname",areaname);
		
		int insertResult=0;
		
		if(result==0) {
			insertResult=sqlsessiontemplate.insert(namespace+".InsertArea",areaname);
		}
		
		return insertResult;
		
	}
	public void deleteArea(String area_seq) {
		sqlsessiontemplate.update(namespace+".DeleteArea",area_seq);
	}
	
	public void updateArea(String area_seq,String areaname) {
		Map<String, String> map=new HashMap<String, String>();
		map.put("area_seq", area_seq);
		map.put("areaname", areaname);
		int result=sqlsessiontemplate.update(namespace+".UpdateArea",map);
		System.out.println("수정결과:"+result);
	}
	
}
