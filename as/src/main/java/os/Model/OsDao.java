package os.Model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class OsDao {

	public List<OsBean> getOsList(){
		List<OsBean> list=new ArrayList();
		return list;
	}
}
