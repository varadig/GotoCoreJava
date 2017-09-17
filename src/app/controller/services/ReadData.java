package app.controller.services;

import java.util.HashMap;

import core.base.CoreBaseClass;
import core.filesystem.CoreFileSystem;
import core.interfaces.ICallable;

public class ReadData extends CoreBaseClass implements ICallable {

	@Override
	public Object execute(HashMap<String, Object> params) 
	{
		return this.sc.getService(CoreFileSystem.READ_TEXT_FILE).addParam(CoreFileSystem.PATH, "/Users/varadig/id_rsa").execute();
	}
}
