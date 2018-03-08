package stswtb.Service;

import java.util.List;
import java.util.Map;

import Paging.StswtbPaging;
import Paging.SwAllVersionPaging;
import Paging.SwVersionManagementPaging;
import stswtb.Model.SwVersionManagementBean;
import sw.Model.SwBean;

public interface StswtbService {
	public abstract List<SwBean> getStandardSwList(StswtbPaging paging,Map<String, String> map);
	public abstract int getTotalCount(Map<String, String> map);
	public abstract List<SwVersionManagementBean> getSwVersionList(SwVersionManagementPaging paging,Map<String, String> map);
	public abstract int getSwTotalCount(Map<String,String> map);
	public abstract List<SwVersionManagementBean> getSwAllVersion(SwAllVersionPaging paging,Map<String, String> map);
	public abstract int getTotalCountFromSwAllVersion(Map<String, String> map);
	
	
}
