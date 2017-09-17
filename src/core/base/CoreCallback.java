package core.base;

import java.util.HashMap;
import java.util.Vector;

import core.interfaces.IExecutable;

public class CoreCallback extends CoreBaseSender {

	public static final String GROUP = "group";
	public static final String ADD_CALLBACK = ".add.callback";
	public static final String ADD_CALLBACKS = ".add.callbacks";
	public static final String CALLBACK = "callback";
	public static final String CALLBACKS = "callbacks";

	public CoreCallback(String name, Vector<IExecutable> collection) {
		super(name, collection);
	}
	
	public HashMap<String, Object> getParams()
	{
		return this.params;
	}
	
	@Override 
	public void send ()
	{
		if(this.collection==null)
			return;
		for (IExecutable service : this.collection)
			service.setParams(this.params).execute();
	}
}
	