package Explorer.Service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Explorer.Model.ExplorerBean;
import Explorer.Model.ExplorerDao;
import Explorer.Model.ExplorerDetailBean;
import Paging.SwAllVersionPaging;
@Service
public class ExplorerServiceImpl implements ExplorerService{

	@Autowired
	ExplorerDao exdao;
	
	@Override
	public List<ExplorerBean> exList(Map<String, String> map) {
		List<ExplorerBean> list = exdao.getExList(map);
		return list;
	}

	@Override
	public int getTotalCount(Map<String, String> map) {
		int getTotalCount = exdao.getTotalCount(map);
		return getTotalCount ;
	}

	@Override
	public int ExdetailListCount(int swnumber) {
		int getTotalCount = exdao.getDetailTotalCount(swnumber);
		return getTotalCount ;
	}

	@Override
	public List<ExplorerDetailBean> getDetailList(int swnumber,SwAllVersionPaging paging) {
		List<ExplorerDetailBean> list = exdao.getExDetailList(swnumber,paging);
		return list;
	}

}
