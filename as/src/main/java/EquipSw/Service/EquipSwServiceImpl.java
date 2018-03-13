package EquipSw.Service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import EquipSw.Model.EquipSwBean;
import EquipSw.Model.EquipSwDao;
import Equipment.Model.EquipmentBean;
import Paging.EqPaging;
import Paging.SwPaging;
import sw.Model.SwBean;

@Service
public class EquipSwServiceImpl implements EquipSwService{

	@Autowired
	EquipSwDao equipswdao;
	
	@Override
	public List<SwBean> getSwList(SwPaging swpaging, Map<String, String> map) {
		List<SwBean> list=equipswdao.getSwList(swpaging, map);
		return list;
	}

	@Override
	public int getSwListSize(Map<String, String> map) {
		int totalCount=equipswdao.getSwListSize(map);
		return totalCount;
	}

	@Override
	public List<SwBean> getStandardSwList(String equipmentid) {
		List<SwBean> list=equipswdao.getStandardSwList(equipmentid);
		return list;
	}

	@Override
	public List<SwBean> getExploreList(String equipmentid) {
		List<SwBean> list=equipswdao.getExploreList(equipmentid);
		return list;
	}

	@Override
	public List<SwBean> getOsList(String equipmentid) {
		List<SwBean> list=equipswdao.getOsList(equipmentid);
		return list;
	}

	@Override
	public int getEqListSize(Map<String, String> map) {
		int result=equipswdao.getEqListSize(map);
		return result;
	}

	@Override
	public List<EquipmentBean> getEqList(EqPaging eqpaging, Map<String, String> map) {
		List<EquipmentBean> eqlist=equipswdao.getEqList(eqpaging,map);
		return eqlist;
	}

	@Override
	public void equipSwRegist(EquipSwBean bean) {
		equipswdao.equipSwRegist(bean);
		
	}

	@Override
	public String getRecordByEquipmentid(String equipmentid) {
		String sumSwname=equipswdao.getRecordByEquipmentid(equipmentid);

		return sumSwname;
	}

	@Override
	public void allDeleteSw(String equipmentid) {
		equipswdao.allDeleteSw(equipmentid);
		
	}



}
