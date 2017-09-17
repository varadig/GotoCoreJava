package core.base.services;

import java.util.HashMap;

import core.base.CoreBaseClassFactory;
import core.interfaces.ICoreObject;
import core.interfaces.ICallable;

public class ServiceAddCallback implements ICallable {

	ICoreObject instance;
	public ServiceAddCallback(ICoreObject instance)
	{
		this.instance = instance;
	}

	@Override
	public Object execute(HashMap<String, Object> params) 
	{
		CoreBaseClassFactory.serviceAddCallback(this.instance,params);
		return null;
	}

}
