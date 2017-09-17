package core.base;

import java.util.Vector;

import core.interfaces.IExecutable;
import core.notification.CoreListener;


public class CoreBaseSender extends CoreBaseParameterHolder
{
	protected String name;
	protected Vector<IExecutable> collection ;
	public CoreBaseSender(String name, Vector<IExecutable> collection)
	{
		this.name = name;
		this.collection = collection;
	}

	
}
