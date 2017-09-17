package javafx.application;

import core.base.CoreBaseClassFactory;
import core.base.CoreCallback;
import core.context.CoreContext;
import core.interfaces.ICoreObject;
import core.interfaces.IExecutable;
import core.service.CoreServiceContainer;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Vector;

/**
 * Created by varadig on 1/25/14.
 */
public class CoreApplication extends Application implements ICoreObject {


    public CoreApplication() {
        this._name = this.generateName();
        this.context = CoreContext.getInstance();
        CoreBaseClassFactory.construct(this);
    }

    @Override
    public void start(Stage stage) throws Exception {

    }

    private String _name;
    protected static int nameIndex = 0;
    protected String namePrefix = "CoreJavaFXAppliaction";
    public CoreServiceContainer sc = CoreServiceContainer.getInstance();
    public CoreContext context = CoreContext.getInstance();
    public HashMap<String, Vector<IExecutable>> callbacks = new HashMap<String, Vector<IExecutable>>();


    @Override
    public String name() {
        return this._name;
    }

    @Override
    public Object execute(HashMap<String, Object> params) {
        String expression = (String) params.get("callable.name");
        if (this.expressionBuilder(".add.callback").equals(expression))
            CoreBaseClassFactory.serviceAddCallback(this, params);
        if (this.expressionBuilder(".add.callbacks").equals(expression))
            CoreBaseClassFactory.serviceAddCallbacks(this, params);
        return null;
    }

    private String expressionBuilder(String slug) {
        return (String) this.name() + slug;
    }

    @Override
    public CoreCallback createCallBack(String group) {
        return CoreBaseClassFactory.createCallBack(group, this.callbacks);
    }


    @Override
    public void log(Object message) {
        CoreBaseClassFactory.log(this, message);
    }

    @Override
    public void log(String message) {
        CoreBaseClassFactory.log(this, message);
    }


    private String generateName() {
        return (String) (this.namePrefix + nameIndex++);
    }


}
