package core.notification.services;

import java.util.HashMap;
import java.util.Vector;

import core.interfaces.ICallable;
import core.interfaces.IExecutable;
import core.notification.CoreListener;
import core.notification.CoreNotificationContainer;

public class RegisterListener implements ICallable
{
	private HashMap<String,Vector<IExecutable>> mapping;

	@Override
	public Object execute(HashMap<String, Object> params)
	{
		this.mapping =CoreNotificationContainer.getInstance().mapping;
		
		String name = (String)params.get("name");
		CoreListener listener = (CoreListener)params.get("listener");

		
		if(!this.hasNotification(name))
			this.mapping.put(name,new Vector<IExecutable>());
		
		this.getListenersOf(name).add(listener);
		return null;
	}
	
	private Vector<IExecutable> getListenersOf(String name)
	{
		return (this.hasNotification(name)?this.mapping.get(name):new Vector<IExecutable>());
	}

	public boolean hasNotification(String name)
	{
		return this.mapping.containsKey(name); 
	}
}
