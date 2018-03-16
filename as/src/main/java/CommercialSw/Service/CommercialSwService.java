package CommercialSw.Service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import CommercialSw.Model.CommercialSwBean;
import CommercialSw.Model.CommercialSwDao;
import CommercialSw.Model.CommercialSwDetailBean;
import Paging.CommercialSwDetailPaging;
import Paging.CommercialSwPaging;
import Paging.OsPaging;


@Service
public class CommercialSwService {

	@Autowired
	CommercialSwDao commercialSwDao;
	

	public List<CommercialSwBean> cswList(CommercialSwPaging paging,Map<String,String> map) {
		List<CommercialSwBean> list=commercialSwDao.cswList(paging,map);
		System.out.println("csw 서비스");
		return list;
	}

	
	public int cswTotalCount(Map<String, String> map) {
		int totalCount=commercialSwDao.cswTotalCount(map);
		
		return totalCount;
	}
	
	public List<CommercialSwDetailBean> cswGetDetailList(CommercialSwDetailPaging paging,String swname){
		List<CommercialSwDetailBean> cswlist=commercialSwDao.cswGetDetailListDao(paging, swname);
		System.out.println("cswdetail 서비스");
		return cswlist;	
	}
	public int cswGetDetailTotal(String swname) {
			int totalCount=commercialSwDao.cswGetDetailTotalDao(swname);
			System.out.println("cswdetailtotal 서비스"+totalCount);
		return totalCount;
	}
	
}
