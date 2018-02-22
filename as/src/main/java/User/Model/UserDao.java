package User.Model;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserDao {

	@Autowired
	SqlSessionTemplate sqlSessiontemplate;
	
	private final String namespace="UserInsertMapper";
	
	public List<AreaBean> getAreaList(){
		List<AreaBean> areaList=sqlSessiontemplate.selectList(namespace+".SelectAreaList");
		return areaList;
	}
	
	public List<OfficeBean> getOfficeList(String area_seq){
		List<OfficeBean> officeList=sqlSessiontemplate.selectList(namespace+".SelectOfficeList",area_seq);
		return officeList;
		
	}
	
	public List<DepartmentBean> getDepartmentList(String office_seq){
		List<DepartmentBean> departmentList=sqlSessiontemplate.selectList(namespace+".SelectDepartmentList",office_seq);
		return departmentList;
	}
	

	
	public String employeeNumberCheck(String employeenumber) {
		System.out.println("emp �ѹ� üũ ����");
		int chkresult=sqlSessiontemplate.selectOne(namespace+".NumberCheckFromLogin",employeenumber);
		String result="";
		if(chkresult==1) {
			result="�̹� ���Ե� ����Դϴ�";
		}else {
			result="��� ������ ����Դϴ�";
		}
		return result;
	}
	
	public int insertUser(EmployeeBean eb) {
		System.out.println("�μ�Ʈ �޼ҵ� ����");
		int count=sqlSessiontemplate.insert(namespace+".InsertUser",eb);
		System.out.println("�μ�Ʈ���: "+count);
		return count;
		
				
		
	}
	
}
