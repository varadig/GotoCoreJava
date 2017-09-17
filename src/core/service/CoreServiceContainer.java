package core.service;

import java.util.HashMap;

import core.interfaces.ICallable;

public class CoreServiceContainer
{
	private static CoreServiceContainer instance;
	private HashMap<String, ICallable> mapping = new HashMap<String, ICallable>();
	
	public static CoreServiceContainer getInstance()
	{
		if(instance == null) 
			instance = new CoreServiceContainer();
		return instance;
	}
	
	public void registerService(String name, ICallable reference)
	{
		this.mapping.put(name, reference);
	}
	
	public void removeService(String name)
	{
		this.mapping.remove(name);
	}
	
	public CoreService getService(String name)
	{
		if(!this.mapping.containsKey(name))
			return null;
		return new CoreService(name,this.mapping.get(name));
	}
}
