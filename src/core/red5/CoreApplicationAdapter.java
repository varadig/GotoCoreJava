package core.red5;

import core.base.CoreBaseClassFactory;
import core.base.CoreCallback;
import core.context.CoreContext;
import core.interfaces.ICoreObject;
import core.interfaces.IExecutable;
import core.service.CoreServiceContainer;
import org.red5.server.adapter.ApplicationAdapter;

import java.util.HashMap;
import java.util.Vector;

/**
 * Created by varadig on 2015. 10. 07..
 */
public class CoreApplicationAdapter extends ApplicationAdapter implements ICoreObject {
    private String _name;
    protected static int nameIndex = 0;
    protected String namePrefix = "button";
    public CoreServiceContainer sc = CoreServiceContainer.getInstance();
    public CoreContext context = CoreContext.getInstance();
    public HashMap<String, Vector<IExecutable>> callbacks = new HashMap<String, Vector<IExecutable>>();

    public CoreApplicationAdapter() {
        this._name = this.generateName();
        CoreBaseClassFactory.construct(this);
        this.context = CoreContext.getInstance();
    }

    @Override
    public String name()
    {
        return this._name;
    }


    public CoreCallback createCallBack(String group)
    {
        return CoreBaseClassFactory.createCallBack( group,this.callbacks);
    }


    @Override
    public void log(Object message)
    {
        CoreBaseClassFactory.log(this, message);
    }

    @Override
    public void log(String message)
    {
        CoreBaseClassFactory.log(this, message);
    }

    @Override
    public Object execute(HashMap<String, Object> params) {
        return null;
    }

    private String generateName() {
        return (String) (this.namePrefix + nameIndex++);
    }

}
