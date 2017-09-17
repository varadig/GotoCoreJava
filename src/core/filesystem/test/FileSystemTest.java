package core.filesystem.test;

import ggui.GuiButton;
import ggui.GuiPanel;
import core.base.CoreCallback;
import core.filesystem.CoreFileSystem;

public class FileSystemTest extends GuiPanel 
{
	public FileSystemTest() {
		GuiButton createTextFile = new GuiButton("CREATE TEXT FILE");
		GuiButton appendTextFile = new GuiButton("APPEND TEXT FILE");
		GuiButton createFolder = new GuiButton("CREATE FOLDER");
		GuiButton readTextFile = new GuiButton("READ TEXT FILE");

		this.add(createTextFile);
		this.add(appendTextFile);
		this.add(createFolder);
		this.add(readTextFile);

		this.sc.getService(createTextFile.getName() + CoreCallback.ADD_CALLBACK)
		.addParam(CoreCallback.GROUP, GuiButton.CLICKED)
		.addParam(
				CoreCallback.CALLBACK,
				this.sc.getService(CoreFileSystem.CREATE_TEXT_FILE)
				.addParam(CoreFileSystem.PATH,
						"/Users/varadig/JAVA.txt")
						.addParam(CoreFileSystem.CONTENT, "CREATE"))
						.execute();
		this.sc.getService(appendTextFile.getName() + CoreCallback.ADD_CALLBACK)
				.addParam(CoreCallback.GROUP, GuiButton.CLICKED)
				.addParam(
						CoreCallback.CALLBACK,
						this.sc.getService(CoreFileSystem.APPEND_TEXT_FILE)
								.addParam(CoreFileSystem.PATH,
										"/Users/varadig/JAVA.txt")
								.addParam(CoreFileSystem.CONTENT, "APPEND"))
				.execute();

		this.sc.getService(createFolder.getName() + CoreCallback.ADD_CALLBACK)
				.addParam(CoreCallback.GROUP, GuiButton.CLICKED)
				.addParam(
						CoreCallback.CALLBACK,
						this.sc.getService(CoreFileSystem.CREATE_FOLDER)
								.addParam(CoreFileSystem.PATH,
										"/Users/varadig/JAVA/")).execute();
	}
}
