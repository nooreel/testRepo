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

}
