package core.base;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Vector;

import core.context.CoreContext;
import core.interfaces.ICoreObject;
import core.interfaces.IExecutable;
import core.service.CoreService;
import core.service.CoreServiceContainer;

public class CoreBaseClassFactory {
	private static CoreServiceContainer _sc =CoreServiceContainer.getInstance();
	private static CoreContext _context = CoreContext.getInstance();

	public static void construct(ICoreObject instance)
	{
		_sc.registerService(instance.name() + ".add.callback", instance);
		_sc.registerService(instance.name() + ".add.callbacks", instance);
	}

	public static void serviceAddCallback(ICoreObject instance,
			HashMap<String, Object> params) 
	{
		String group = (String) params.get("group");
		
		CoreService callback = (CoreService) params.get("callback");
		CoreBaseClassFactory.addCallback(instance, group, callback);
	}

	public static void serviceAddCallbacks(ICoreObject instance,
			HashMap<String, Object> params) {
		String group = (String) params.get("group");
		for (IExecutable cb : (Vector<IExecutable>) params.get("callbacks"))
			CoreBaseClassFactory.addCallback(instance, group, cb);
	}

	private static void addCallback(ICoreObject instance, String group,
			IExecutable callback) {
		if (!getCallbacks(instance).containsKey(group))
			getCallbacks(instance).put(group, new Vector<IExecutable>());
		getCallbacks(instance).get(group).add(callback);
	}

	public static CoreCallback createCallBack(
			String group,HashMap<String, Vector<IExecutable>> callbacks) {
		return new CoreCallback(group, callbacks.get(group));
	}

	public static void log(ICoreObject instance, Object message)
	{
		_sc.getService("logger.log").addParam("message", message).execute();
	}

	private static HashMap<String, Vector<IExecutable>> getCallbacks(
			ICoreObject instance) {
		HashMap<String, Vector<IExecutable>> _callbacks = null;
		Field callbacks = null;
		try {
			callbacks = instance.getClass().getSuperclass()
					.getDeclaredField("callbacks");
			_callbacks = (HashMap<String, Vector<IExecutable>>) callbacks
					.get(instance);
		} catch (NoSuchFieldException e) {
			try {
				callbacks = instance.getClass().getDeclaredField("callbacks");
				_callbacks = (HashMap<String, Vector<IExecutable>>) callbacks.get(instance);
			} catch (NoSuchFieldException | SecurityException e1) {
				e1.printStackTrace();
			} catch (IllegalArgumentException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return _callbacks;
	}

}
