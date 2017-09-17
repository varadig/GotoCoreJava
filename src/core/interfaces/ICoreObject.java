package core.interfaces;

import core.base.CoreCallback;


public interface ICoreObject extends ICallable
{
	public String name();
	public CoreCallback createCallBack(String group);
	public void log(Object message);
	public void log(String message);
}
