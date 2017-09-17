package core.service;

import core.base.CoreBaseFunctionWrapper;
import core.interfaces.ICallable;


public class CoreService extends CoreBaseFunctionWrapper
{
	public CoreService(String name, ICallable reference)
	{
		super(name, reference);	
	}
	@Override
	public Object execute()
	{
		return this.call();
	}
}
