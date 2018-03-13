package nclientInfo.Service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Paging.NClientInfoByAreaPaging;
import Paging.NClientInfoPaging;
import nclientInfo.Model.NclientDao;
import nclientInfo.Model.NclientInfoByAreaBean;
import nclientInfo.Model.NclientInfoByAreaToDepartmentBean;

@Service
public class NclientInfoServiceImpl implements NclientInfoService{

	@Autowired
	NclientDao nclientdao;
	
	@Override
	public int getTotalCountNClientInfoByArea(Map<String, String> map) {
		int totalCount=nclientdao.getTotalCountNClientInfoByArea(map);
		return totalCount;
		
	}

	@Override
	public List<NclientInfoByAreaBean> getNClientInfoByArea(NClientInfoPaging paging, Map<String, String> map) {
		List<NclientInfoByAreaBean> list=nclientdao.getNClientInfoByArea(paging, map);
		return list;
	}

	@Override
	public int getAreaToDepartmentTotalCount(String area_seq) {
		int totalCount=nclientdao.getAreaToDepartmentTotalCount(area_seq);
		return totalCount;
	}

	@Override
	public List<NclientInfoByAreaToDepartmentBean> getAreaToDepartmentList(NClientInfoByAreaPaging paging,
			String area_seq) {
		List<NclientInfoByAreaToDepartmentBean> list=nclientdao.getAreaToDepartmentList(paging, area_seq);
		return list;
	}

	@Override
	public List<NclientInfoByAreaBean> exceltest() {
		List<NclientInfoByAreaBean> list=nclientdao.exceltest();
		return list;
	}

}
