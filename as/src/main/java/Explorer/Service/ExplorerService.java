package Explorer.Service;

import java.util.List;
import java.util.Map;

import Explorer.Model.ExplorerBean;
import Explorer.Model.ExplorerDetailBean;
import Paging.SwAllVersionPaging;

public interface ExplorerService {
	
	public abstract List<ExplorerBean> exList(Map<String,String> map);
	public abstract int getTotalCount(Map<String,String> map);
	public abstract int ExdetailListCount(int swnumber);
	public abstract List<ExplorerDetailBean> getDetailList(int swnumber,SwAllVersionPaging paging);
}