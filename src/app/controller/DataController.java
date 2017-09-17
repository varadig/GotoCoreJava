package app.controller;

import app.controller.services.ReadData;
import core.base.CoreBaseClass;

public class DataController extends CoreBaseClass{

	public static final String READ_DATA = "read.data";
	private static DataController instance;
	
	public static DataController getInstance() {
		if (instance == null)
			instance = new DataController();
		return instance;
	}
	
	public DataController() 
	{
		this.sc.registerService(READ_DATA, new ReadData());
	}
}
