package core.base.services;

import java.util.HashMap;

import core.base.CoreBaseClassFactory;
import core.interfaces.ICoreObject;
import core.interfaces.ICallable;

public class ServiceAddCallbacks implements ICallable {

	private ICoreObject instance;
	public ServiceAddCallbacks(ICoreObject instance)
	{
		this.instance = instance;
	}
	
	public Object execute(HashMap<String, Object> params) 
	{
			CoreBaseClassFactory.serviceAddCallbacks(this.instance,params);
		return null;
	}

}
