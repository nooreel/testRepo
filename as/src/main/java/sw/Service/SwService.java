package sw.Service;

import sw.Model.SwBean;

public interface SwService {
	public abstract void swInsert(SwBean bean);
	public abstract void swUpdate(SwBean bean);
	public abstract void swDelete(String swnumber);
	public abstract void getSwList();
	public abstract SwBean getSwRecord(String swnumber);
}
