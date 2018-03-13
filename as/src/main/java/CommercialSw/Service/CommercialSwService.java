package CommercialSw.Service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import CommercialSw.Model.CommercialSwBean;
import CommercialSw.Model.CommercialSwDao;
import Paging.CommercialSwPaging;
import Paging.OsPaging;


@Service
public class CommercialSwService {

	@Autowired
	CommercialSwDao commercialSwDao;
	

	public List<CommercialSwBean> cswList(CommercialSwPaging paging,Map<String,String> map) {
		List<CommercialSwBean> list=commercialSwDao.cswList(paging,map);
		System.out.println("csw ¼­ºñ½º");
		return list;
	}

	
	public int cswTotalCount(Map<String, String> map) {
		int totalCount=commercialSwDao.cswTotalCount(map);
		
		return totalCount;
	}
}
