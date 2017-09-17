package core.base;

import core.interfaces.IExecutable;

import java.util.HashMap;

public class CoreBaseParameterHolder implements IExecutable {
    protected HashMap<String, Object> params = new HashMap<String, Object>();

    @Override
    public IExecutable addParam(String name, Object value) {
        if (!this.params.containsKey(name))
            this.params.put(name, value);
        return this;
    }

    @Override
    public IExecutable setParam(String name, Object value) {
        this.params.put(name, value);
        return this;
    }

    @Override
    public IExecutable addParams(HashMap<String, Object> params) {
        this.params.putAll(params);
        return this;
    }

    @Override
    public IExecutable setParams(HashMap<String, Object> params) {
        this.params.putAll(params);
        return this;
    }

    @Override
    public Boolean hasParam(String param) {
        return this.params.containsKey(param);
    }

    @Override
    public Object execute() {
        return null;
    }

    @Override
    public void send() {

    }

    @Override
    public void alert() {

    }
}
