package core.notification.services;

import java.util.HashMap;
import java.util.Vector;

import core.interfaces.ICallable;
import core.interfaces.IExecutable;
import core.notification.CoreListener;
import core.notification.CoreNotificationContainer;

public class RemoveListener implements ICallable
{
	private HashMap<String,Vector<IExecutable>> mapping;

	@Override
	public Object execute(HashMap<String, Object> params)
	{
		this.mapping =CoreNotificationContainer.getInstance().mapping;
		
		String name = (String)params.get("name");
		CoreListener listener = (CoreListener)params.get("listener");
		
		return null;
	}

}
