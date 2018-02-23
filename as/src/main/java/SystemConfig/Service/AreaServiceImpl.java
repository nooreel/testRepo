package SystemConfig.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SystemConfig.Model.AreaDao;
@Service
public class AreaServiceImpl implements AreaService{

	@Autowired
	AreaDao areadao;
	
	@Override
	public int insertArea(String areaname) {
		int result=areadao.insertArea(areaname);
		return result;
	}

	@Override
	public void deleteArea(String area_seq) {
		areadao.deleteArea(area_seq);
	}

	@Override
	public void UpdateaArea(String area_seq, String areaname) {
		areadao.updateArea(area_seq, areaname);
	}

}
