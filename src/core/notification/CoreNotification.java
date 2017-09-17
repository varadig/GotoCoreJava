package core.notification;

import java.util.Vector;

import core.base.CoreBaseSender;
import core.interfaces.IExecutable;

public class CoreNotification extends CoreBaseSender
{

	public static final String CREATE_NOTIFICATION = "create.notification";
	public static final String NAME = "name";
	

	public CoreNotification(String name, Vector<IExecutable> collection)
	{
		super(name, collection);
	}
	
	@Override
	public void send()
	{
		for (IExecutable listener : this.collection)
			listener.setParams(this.params).alert();
	}
}
