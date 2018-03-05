package EquipSw.Model;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import Equipment.Model.EquipmentBean;
import Paging.EqPaging;
import Paging.SwPaging;
import sw.Model.SwBean;

@Component
public class EquipSwDao {

	private final String namespace="EquipSwMapper";
	
	@Autowired
	SqlSessionTemplate sqlsessiontemplate;
	
	public List<SwBean> getSwList(SwPaging swpaging,Map<String, String> map){
		System.out.println("오프셋: "+swpaging.getOffset());
		System.out.println("리밋:"+swpaging.getLimit());
		System.out.println("페이지사이즈:"+swpaging.getPageSize());

		
		RowBounds rowbounds=new RowBounds(swpaging.getOffset(),swpaging.getLimit());
		List<SwBean> swlist=sqlsessiontemplate.selectList(namespace+".SelectSwList",map,rowbounds);
		System.out.println("리스트사이즈:"+swlist.size());
		
		return swlist;
	}

	public int getSwListSize(Map<String, String> map) {
		int totalCount=sqlsessiontemplate.selectOne(namespace+".GetTotalCountSw",map);
		return totalCount;
	}
	
	public List<SwBean> getStandardSwList(){
		List<SwBean> list=sqlsessiontemplate.selectList(namespace+".SelectStandardSw");
		return list;
	}
	
	public List<SwBean> getExploreList(){
		List<SwBean> list=sqlsessiontemplate.selectList(namespace+".SelectExplorer");
		return list;
	}
	
	public List<SwBean> getOsList(){
		List<SwBean> list=sqlsessiontemplate.selectList(namespace+".SelectOS");
		return list;
	}
	
	public int getEqListSize(Map<String,String> map) {
		int result=sqlsessiontemplate.selectOne(namespace+".GetTotalCountEq",map);
		return result;
	}
	public List<EquipmentBean> getEqList(EqPaging eqpaging,Map<String, String> map){
		RowBounds rowbounds=new RowBounds(eqpaging.getOffset(),eqpaging.getLimit());
		List<EquipmentBean> eqlist=sqlsessiontemplate.selectList(namespace+".SelectEqList",map,rowbounds);
		return eqlist;
	}
	
	public void equipSwRegist(EquipSwBean bean) {
		
		for(int i=0;i<bean.getSw().length;i++) {
			int swnumber=bean.getSw()[i];
			EquipSwBean newbean=new EquipSwBean();
			newbean.setSwnumber(swnumber);
			newbean.setEquipmentid(bean.getEquipmentid());
			sqlsessiontemplate.insert(namespace+".InsertSwToEquipSwTable",newbean);
		}
		sqlsessiontemplate.insert(namespace+".InsertExplorerToEquipSwTable",bean);
		sqlsessiontemplate.insert(namespace+".InsertOsToEquipSwTable",bean);
	}
	public String getRecordByEquipmentid(String equipmentid) {
		List<EquipSwBean> list=sqlsessiontemplate.selectList(namespace+".GetRecordEquipmentid",equipmentid);
		String sumSwname="";
		for(int i=0;i<list.size();i++) {
			if(list.get(i).getSwname().equals("Explorer")) {
				sumSwname+=list.get(i).getSwname()+list.get(i).getSwversion()+",";
			}else {
				sumSwname+=list.get(i).getSwname()+",";
			}
		}
		return sumSwname;
	}
	
}
