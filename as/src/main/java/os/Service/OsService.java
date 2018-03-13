package os.Service;

import java.util.List;
import java.util.Map;

import Paging.OsDetailPaging;
import Paging.OsPaging;
import os.Model.OsBean;
import os.Model.OsDetailBean;

public interface OsService {
	public abstract List<OsBean> getOsList(OsPaging paging,Map<String,String> map);
	public abstract int getOsTotalCount(Map<String,String> map);
	public abstract List<OsDetailBean> getOsDetailList(OsDetailPaging detailPaging, Map<String, String> detailmap);
	public abstract int getDetailTotalCount(Map<String,String> detailmap);
}
