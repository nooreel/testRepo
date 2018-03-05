package Equipment.Model;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EquipmentDao {

	private final String namespace="EquipmentMapper";
	
	@Autowired
	SqlSessionTemplate sqlsessiontemplate;
	
	public void equipmentRegist(EquipmentBean bean) {
		sqlsessiontemplate.insert(namespace+".EquipmentRegist",bean);
	}
	
}
