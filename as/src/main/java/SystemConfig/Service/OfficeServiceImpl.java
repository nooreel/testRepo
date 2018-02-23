package SystemConfig.Service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SystemConfig.Model.AreaOfficeBean;
import SystemConfig.Model.OfficeDao;

@Service
public class OfficeServiceImpl implements OfficeService{

	@Autowired
	OfficeDao officedao;
	
	@Override
	public void DeleteOffice(String office_seq) {
		officedao.DeleteOffice(office_seq);
		
	}

	@Override
	public void InsertOffice(Map<String, String> map) {
		// TODO Auto-generated method stub
		officedao.InsertOffice(map);
	}

	@Override
	public AreaOfficeBean getOfficeRecord(String office_seq) {
		AreaOfficeBean bean=officedao.getOfficeRecord(office_seq);
		return bean;
	}

	@Override
	public void updateOffice(AreaOfficeBean bean) {
		officedao.updateOffice(bean);
	}

	
}
