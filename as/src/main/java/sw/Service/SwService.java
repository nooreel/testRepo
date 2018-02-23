package sw.Service;

import sw.Model.SwBean;

public interface SwService {
	public abstract void swInsert(SwBean bean);
	public abstract void swUpdate();
	public abstract void swDelete();
	public abstract void getSwList();
}
