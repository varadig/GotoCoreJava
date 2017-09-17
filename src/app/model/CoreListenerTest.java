package app.model;

import java.util.HashMap;

import core.base.CoreBaseClass;
import core.interfaces.ICallable;
import core.notification.CoreListener;

public class CoreListenerTest extends CoreBaseClass 
{
	private CoreListener listener;

	public CoreListenerTest()
	{
		this.listener = new CoreListener("core.listener.test", new ICallable() {
			
			@Override
			public Object execute(HashMap<String, Object> params) {
				// 
				return null;
			}
		});
		this.sc.getService(CoreListener.REGISTER_LISTENER).addParam(CoreListener.NAME, "core.listener.test").addParam(CoreListener.LISTENER, this.listener).execute();
	}
}
