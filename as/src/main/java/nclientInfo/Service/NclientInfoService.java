package nclientInfo.Service;

import java.util.List;
import java.util.Map;

import Paging.NClientInfoByAreaPaging;
import Paging.NClientInfoPaging;
import nclientInfo.Model.NclientInfoByAreaBean;
import nclientInfo.Model.NclientInfoByAreaToDepartmentBean;

public interface NclientInfoService {

	public int getTotalCountNClientInfoByArea(Map<String,String> map);
	public List<NclientInfoByAreaBean> getNClientInfoByArea(NClientInfoPaging paging,Map<String,String> map);
	public int getAreaToDepartmentTotalCount(String area_seq);
	public List<NclientInfoByAreaToDepartmentBean> getAreaToDepartmentList(NClientInfoByAreaPaging paging,String area_seq);
	public List<NclientInfoByAreaBean> exceltest();
}
