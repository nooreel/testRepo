package os.Service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Paging.OsDetailPaging;
import Paging.OsPaging;
import os.Model.OsBean;
import os.Model.OsDao;
import os.Model.OsDetailBean;

@Service
public class OsServiceImpl implements OsService{

	@Autowired
	OsDao osdao;
	
	@Override
	public List<OsBean> getOsList(OsPaging paging,Map<String,String> map) {
		List<OsBean> list=osdao.getOsList(paging,map);
		return list;
	}

	@Override
	public int getOsTotalCount(Map<String, String> map) {
		int totalCount=osdao.getOsTotalCount(map);
		return totalCount;
	}

	@Override
	public List<OsDetailBean> getOsDetailList(OsDetailPaging detailPaging, Map<String, String> detailmap) {
		List<OsDetailBean> list=osdao.getOsDetailList(detailPaging,detailmap);
		return list;
	}

	@Override
	public int getDetailTotalCount(Map<String, String> detailmap) {
		int detailTotalCount=osdao.getDetailTotalCount(detailmap);
		return detailTotalCount;
	}
	


	
	
}
