package stswtb.Service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Paging.StswtbPaging;
import Paging.SwAllVersionPaging;
import Paging.SwVersionManagementPaging;
import stswtb.Model.StswtbDao;
import stswtb.Model.SwVersionManagementBean;
import sw.Model.SwBean;

@Service
public class StswtbServiceImpl implements StswtbService{

	@Autowired
	StswtbDao stswtbdao;
	


	@Override
	public int getTotalCount(Map<String, String> map) {
		int totalCount=stswtbdao.getTotalCount(map);
		return totalCount;
	}



	@Override
	public List<SwBean> getStandardSwList(StswtbPaging paging, Map<String, String> map) {
		List<SwBean> list=stswtbdao.getStandardSwList(paging, map);
		return list;
	}



	@Override
	public List<SwVersionManagementBean> getSwVersionList(SwVersionManagementPaging paging,Map<String, String> map) {
		List<SwVersionManagementBean> list=stswtbdao.getSwVersionList(paging,map);
		return list;
	}



	@Override
	public int getSwTotalCount(Map<String, String> map) {
		int totalCount=stswtbdao.getSwTotalCount(map);
		return totalCount;
	}



	@Override
	public List<SwVersionManagementBean> getSwAllVersion(SwAllVersionPaging paging,Map<String, String> map) {
		List<SwVersionManagementBean> list=stswtbdao.getSwAllVersion(paging,map);
		return list;
	}



	@Override
	public int getTotalCountFromSwAllVersion(Map<String, String> map) {
		int totalCount=stswtbdao.getTotalCountFromSwAllVersion(map);
		return totalCount;
	}
	
	
	
}
