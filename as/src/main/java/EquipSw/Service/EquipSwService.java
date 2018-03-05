package EquipSw.Service;

import java.util.List;
import java.util.Map;

import EquipSw.Model.EquipSwBean;
import Equipment.Model.EquipmentBean;
import Paging.EqPaging;
import Paging.SwPaging;
import sw.Model.SwBean;

public interface EquipSwService {

	public abstract List<SwBean> getSwList(SwPaging swpaging,Map<String, String> map);
	public abstract int getSwListSize(Map<String, String> map);
	public abstract List<SwBean> getStandardSwList();
	public abstract List<SwBean> getExploreList();
	public abstract List<SwBean> getOsList();
	public abstract int getEqListSize(Map<String,String> map);
	public abstract List<EquipmentBean> getEqList(EqPaging eqpaging,Map<String,String> map);
	public abstract void equipSwRegist(EquipSwBean bean);
	public abstract String getRecordByEquipmentid(String equipmentid);

}



