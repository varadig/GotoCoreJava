package core.context;

import core.base.CoreBaseParameterHolder;
import core.service.CoreServiceContainer;
import javafx.stage.Stage;

public class CoreContext extends CoreBaseParameterHolder
{
    public Stage stage;
	private static CoreContext instance;
	public CoreServiceContainer sc;
	
	public static CoreContext getInstance()
	{
		if (instance == null)
			instance = new CoreContext();
		return instance;
	}

	public CoreContext()
	{
				this.sc = CoreServiceContainer.getInstance();
	}
	
	public Object getParam(String name)
	{
		return this.params.get(name);
	}
}
