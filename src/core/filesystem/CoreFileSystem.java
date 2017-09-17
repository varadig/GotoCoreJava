package core.filesystem;

import java.util.HashMap;

import core.base.CoreBaseClass;
import core.base.CoreBaseFunctionWrapper;
import core.filesystem.base.CoreBaseFileSytem;
import core.interfaces.ICallable;

public class CoreFileSystem extends CoreBaseClass implements ICallable {
	/* SERVICES */
	public static final String FILE_EXISTS = "file.existes";
	public static final String FOLDER_EXISTS = "folder.exists";
	public static final String CREATE_FOLDER = "create.folder";
	public static final String COPY_FILE = "copy.file";
	public static final String COPY_FOLDER = "copy.folder";
	public static final String CREATE_TEXT_FILE = "create.text.file";
	public static final String CREATE_BINARY_FILE = "create.binary.file";
	public static final String APPEND_TEXT_FILE = "append.text.file";
	public static final String READ_TEXT_FILE = "read.text.file";
	public static final String READ_BINARY_FILE = "read.binary.file";
	public static final String DELETE_FILE = "delete.file";
	public static final String DELETE_FOLDER = "delete.folder";

	/* PARAMS */
	public static final String PATH = "path";
	public static final String CONTENT = "content";

	private static CoreFileSystem instance;
	private CoreBaseFileSytem filesystem;

	public static CoreFileSystem getInstance(CoreBaseFileSytem filesystem) {
		if (instance == null)
			instance = new CoreFileSystem(filesystem);
		return instance;

	}

	public CoreFileSystem(CoreBaseFileSytem filesystem) {
		this.filesystem = filesystem;
		this.sc.registerService(FILE_EXISTS, this);
		this.sc.registerService(FOLDER_EXISTS, this);
		this.sc.registerService(CREATE_FOLDER, this);
		this.sc.registerService(COPY_FILE, this);
		this.sc.registerService(COPY_FOLDER, this);
		this.sc.registerService(CREATE_TEXT_FILE, this);
		this.sc.registerService(CREATE_BINARY_FILE, this);
		this.sc.registerService(APPEND_TEXT_FILE, this);
		this.sc.registerService(READ_TEXT_FILE, this);
		this.sc.registerService(READ_BINARY_FILE, this);
		this.sc.registerService(DELETE_FILE, this);
		this.sc.registerService(DELETE_FOLDER, this);
	}

	@Override
	public Object execute(HashMap<String, Object> params) {
		if(params.get(CoreBaseFunctionWrapper.CALLABLE_NAME).equals(FILE_EXISTS)||params.get(CoreBaseFunctionWrapper.CALLABLE_NAME).equals(FOLDER_EXISTS))
			return this.serviceFileExists(params);
		if(params.get(CoreBaseFunctionWrapper.CALLABLE_NAME).equals(CREATE_FOLDER))
			this.serviceCreateFolder(params);
		if(params.get(CoreBaseFunctionWrapper.CALLABLE_NAME).equals(COPY_FILE)||params.get(CoreBaseFunctionWrapper.CALLABLE_NAME).equals(COPY_FOLDER))
			this.serviceCopyFile(params);
		if(params.get(CoreBaseFunctionWrapper.CALLABLE_NAME).equals(CREATE_TEXT_FILE)||params.get(CoreBaseFunctionWrapper.CALLABLE_NAME).equals(CREATE_BINARY_FILE))
			this.serviceCreateTextFile(params);
		if(params.get(CoreBaseFunctionWrapper.CALLABLE_NAME).equals(APPEND_TEXT_FILE))
			this.serviceAppendTextFile(params);
		if(params.get(CoreBaseFunctionWrapper.CALLABLE_NAME).equals(READ_TEXT_FILE))
			return this.serviceReadTextFile(params);
		if(params.get(CoreBaseFunctionWrapper.CALLABLE_NAME).equals(READ_BINARY_FILE))
			return this.serviceReadBinaryFile(params);
		if(params.get(CoreBaseFunctionWrapper.CALLABLE_NAME).equals(DELETE_FILE)||params.get(CoreBaseFunctionWrapper.CALLABLE_NAME).equals(DELETE_FOLDER))
			this.serviceDeleteFile(params);
		return null;
	}

	private void serviceAppendTextFile(HashMap<String, Object> params) {

		this.filesystem.appendTextFile(params);
	}

	private void serviceDeleteFile(HashMap<String, Object> params) {
		this.filesystem.deleteFile(params);
	}

	private Object serviceReadBinaryFile(HashMap<String, Object> params) {
		return this.filesystem.readBinaryFile(params);
	}

	private Object serviceReadTextFile(HashMap<String, Object> params) {
		return this.filesystem.readTextFile(params);
	}

	private void serviceCreateTextFile(HashMap<String, Object> params) {
		this.filesystem.createTextFile(params);
	}

	private void serviceCopyFile(HashMap<String, Object> params) {
		this.filesystem.copyFile(params);
	}

	private boolean serviceFileExists(HashMap<String, Object> params) {
		return this.filesystem.fileExists(params);
	}

	private void serviceCreateFolder(HashMap<String, Object> params) {
		this.filesystem.createFolder(params);
	}
}
