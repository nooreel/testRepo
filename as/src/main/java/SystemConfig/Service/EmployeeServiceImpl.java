package SystemConfig.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SystemConfig.Model.EmployeeDao;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	EmployeeDao employeedao;

	@Override
	public void DeleteEmployee(String employeenumber) {
		employeedao.DeleteEmployee(employeenumber);
	}

}
