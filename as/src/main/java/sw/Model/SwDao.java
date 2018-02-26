package sw.Model;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SwDao {

	private final static String namespace="SwMapper";
	
	@Autowired
	SqlSessionTemplate sqlsessiontemplate;
	
	public void swInsert(SwBean bean) {
		System.out.println(bean.getUsed());
		System.out.println(bean.getQuantity());
		sqlsessiontemplate.insert(namespace+".SwInsert",bean);
	}
	
	
}
