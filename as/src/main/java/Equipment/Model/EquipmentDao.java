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
	
	public EquipmentBean equipmentSelect(String equipmentid) {
		EquipmentBean bean = sqlsessiontemplate.selectOne(namespace+".EquipmentSelect", equipmentid);
		return bean;
		
	}
	
	public void equipmentUpdate(EquipmentBean bean) {
		sqlsessiontemplate.update(namespace+".EquipmentUpdate", bean);
		
	}
	
	
	public void equipmentDelete(String equipmentid) {
		sqlsessiontemplate.delete(namespace+".EquipmentDelete", equipmentid);
	}
}
