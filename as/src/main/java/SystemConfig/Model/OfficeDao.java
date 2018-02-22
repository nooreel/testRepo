package SystemConfig.Model;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OfficeDao {
	
	@Autowired
	SqlSessionTemplate sqlsessiontemplate;
	
	
	private final String namespace="OfficeMapper";
	
	public void DeleteOffice(String office_seq){
		System.out.println("¿ÀÇÇ½º seq:"+office_seq);	
		sqlsessiontemplate.update(namespace+".DeleteOffice",office_seq);
	}
	
	public void InsertOffice(Map<String, String> map) {
		sqlsessiontemplate.insert(namespace+".InsertOffice",map);
	}
	
	public AreaOfficeBean getOfficeRecord(String office_seq) {
		AreaOfficeBean bean=sqlsessiontemplate.selectOne(namespace+".GetOfficeRecord",office_seq);
		return bean;
	}
	
	public void updateOffice(AreaOfficeBean bean) {
		sqlsessiontemplate.update(namespace+".UpdateOffice",bean);
	}
	
}
