package os.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import os.Model.OsBean;
import os.Model.OsDao;

@Service
public class OsServiceImpl implements OsService{

	@Autowired
	OsDao osdao;
	
	@Override
	public List<OsBean> getOsList() {
		List<OsBean> list=osdao.getOsList();
		return list;
	}

	
	
}
