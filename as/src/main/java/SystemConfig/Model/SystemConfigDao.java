package SystemConfig.Model;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import User.Model.AreaBean;
import User.Model.OfficeBean;

@Component
public class SystemConfigDao {

@Autowired
SqlSessionTemplate sqlsessiontemplate;

private final String namespace="SystemConfigMapper";

public List<AreaBean> getAreaList(){
	List<AreaBean> arealist=sqlsessiontemplate.selectList(namespace+".SelectAreaList");
	return arealist;
}
	
public List<AreaOfficeBean> getOfficeList(){
	List<AreaOfficeBean> officelist=sqlsessiontemplate.selectList(namespace+".SelectOfficeList");
	return officelist;
}

public List<AreaOfficeDepartmentBean> getDepartmentList(){
	List<AreaOfficeDepartmentBean> departmentlist=sqlsessiontemplate.selectList(namespace+".SelectDepartmentList");
	return departmentlist;
}

public List<EmployeeBean> getEmployeeList(){
	List<EmployeeBean> employeelist=sqlsessiontemplate.selectList(namespace+".SelectEmployeeList");
	return employeelist;
}

}
