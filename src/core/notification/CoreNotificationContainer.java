package core.notification;

import java.util.HashMap;
import java.util.Vector;

import core.base.CoreBaseClass;
import core.interfaces.IExecutable;
import core.notification.services.CreateNotification;
import core.notification.services.RegisterListener;
import core.notification.services.RemoveListener;

public class CoreNotificationContainer extends CoreBaseClass
{
	private static CoreNotificationContainer instance;
	public HashMap<String,Vector<IExecutable>> mapping = new HashMap<String,Vector<IExecutable>>();

	public static CoreNotificationContainer getInstance()
	{
		if (instance == null)
			instance = new CoreNotificationContainer();
		return instance;
	}

	public CoreNotificationContainer()
	{
		super();
		this.sc.registerService(CoreListener.REGISTER_LISTENER, new RegisterListener());
		this.sc.registerService(CoreListener.REMOVE_LISTENER, new RemoveListener());
		this.sc.registerService(CoreNotification.CREATE_NOTIFICATION, new CreateNotification());
	}
}
