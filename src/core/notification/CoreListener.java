package core.notification;

import core.base.CoreBaseFunctionWrapper;
import core.interfaces.ICallable;

public class CoreListener extends CoreBaseFunctionWrapper
{

	public static final String REGISTER_LISTENER = "register.listener";
	public static final String REMOVE_LISTENER = "remove.listener";
	public static final String LISTENER= "listener";
	public static final String NAME= "name";
	

	public CoreListener(String name, ICallable reference)
	{
		super(name, reference);
	}
	
	@Override
	public void alert()
	{
		this.call();
	}
}
