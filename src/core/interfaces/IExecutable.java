package core.interfaces;

import java.util.HashMap;


public interface IExecutable
{
	public Object execute();
	public IExecutable addParam(String name, Object value);
	public IExecutable addParams(HashMap<String, Object> params);
	public IExecutable setParam(String name, Object value);
	public IExecutable setParams(HashMap<String, Object> params);
	public Boolean hasParam(String param);
	public void send();
	public void alert();

}
