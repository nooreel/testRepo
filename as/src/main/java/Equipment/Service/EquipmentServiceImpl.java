package Equipment.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Equipment.Model.EquipmentBean;
import Equipment.Model.EquipmentDao;

@Service
public class EquipmentServiceImpl implements EquipmentService{

	@Autowired
	EquipmentDao equipmentdao;
	
	@Override
	public void EquipmentRegist(EquipmentBean bean) {
		equipmentdao.equipmentRegist(bean);
	}
	
	@Override
	public EquipmentBean EqupimentSelect(String equipmentid) {
		EquipmentBean bean= equipmentdao.equipmentSelect(equipmentid);
		return bean;
	}



	@Override
	public void EquipmentDelete(String equipmentid) {
		equipmentdao.equipmentDelete(equipmentid);
		
		
	}

	@Override
	public void EquipmentUpdate(EquipmentBean bean) {
		equipmentdao.equipmentUpdate(bean);
		
	}

	@Override
	public String equipmentIdCheck(String equipmentid) {
		String result = equipmentdao.equipmentCheck(equipmentid);
		return result;
	}



}
