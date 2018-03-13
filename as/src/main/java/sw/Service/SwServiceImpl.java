package sw.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sw.Model.SwBean;
import sw.Model.SwDao;

@Service
public class SwServiceImpl implements SwService{

	@Autowired
	SwDao swdao;
	
	@Override
	public void swInsert(SwBean bean) {
		swdao.swInsert(bean);
	}

	@Override
	public void swUpdate(SwBean bean) {
		swdao.swUpdate(bean);
	}

	@Override
	public void swDelete(String swnumber) {
		swdao.swDelete(swnumber);
		
	}

	@Override
	public void getSwList() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public SwBean getSwRecord(String swnumber) {
		SwBean bean=swdao.getSwRecord(swnumber);
		return bean;
	}
	
	
}
