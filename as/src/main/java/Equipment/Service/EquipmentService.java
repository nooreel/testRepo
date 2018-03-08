package Equipment.Service;

import Equipment.Model.EquipmentBean;

public interface EquipmentService {
	public abstract void EquipmentRegist(EquipmentBean bean);
	public abstract EquipmentBean EqupimentSelect(String equipmentid);
	public abstract void EquipmentUpdate(EquipmentBean bean);
	public abstract void EquipmentDelete(String equipmentid);
}
