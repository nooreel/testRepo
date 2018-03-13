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
	
	public String equipmentCheck(String equipmentid) {
		int chk = 0;
		String result="";
		chk = sqlsessiontemplate.selectOne(namespace+".EquipmentIdCheck", equipmentid);
		if(chk==1) {
			result="이미 등록된 아이디 입니다.";
			
		}else {
			
			result ="사용 가능한 아이디 입니다.";
			
		}
		
		return result;
	}
}
