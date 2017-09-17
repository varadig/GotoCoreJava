package core.base;

import core.interfaces.ICallable;
import core.interfaces.IExecutable;

public class CoreBaseFunctionWrapper extends CoreBaseParameterHolder
{

	protected String name;
	protected ICallable reference;
	public static final String CALLABLE_NAME = "callable.name";
	
	public CoreBaseFunctionWrapper(String name, ICallable reference)
	{
		this.name = name;
		this.reference = reference;
		this.addParam("callable.name", name);
	}
	
	protected Object call() 
	{
		return this.reference.execute(this.params);
		
	}
	
	public IExecutable clone()
	{
		return null;
	}
	
}
