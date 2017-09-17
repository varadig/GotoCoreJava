package core.filesystem.version;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.HashMap;

import core.filesystem.base.CoreBaseFileSytem;

public class CoreFileSystemJava7 extends CoreBaseFileSytem {

	@Override
	public void appendTextFile(HashMap<String, Object> params) {
		System.out.println("APPEN TEXT FILE");
		Path path = Paths.get((String) params.get("path"));

		String content = (String) params.get("content");

		OutputStream os = null;
		try {

			os = Files.newOutputStream(path, StandardOpenOption.CREATE,
					StandardOpenOption.APPEND);
			os.write(content.getBytes(), 0, content.length());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				os.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void deleteFile(HashMap<String, Object> params) {
		String path = (String) params.get("path");
		try {
			Path fpath = FileSystems.getDefault().getPath(path);
			Files.delete(fpath);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Object readBinaryFile(HashMap<String, Object> params) {

		byte[] filearray = null;
		String path = (String) params.get("path");

		try {
			Path fpath = FileSystems.getDefault().getPath(path);
			return Files.readAllBytes(fpath);
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		return filearray;
	}

	@Override
	public Object readTextFile(HashMap<String, Object> params) {
		try {
			return Files.readAllLines(
					FileSystems.getDefault().getPath(
							(String) params.get("path")),
					Charset.defaultCharset());
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		return null;
	}

	@Override
	public void createTextFile(HashMap<String, Object> params) {
		String path = (String) params.get("path");
		String content = (String) params.get("content");
		try {
			Files.write(FileSystems.getDefault().getPath(path),
					content.getBytes(), StandardOpenOption.CREATE);
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	@Override
	public void copyFile(HashMap<String, Object> params) {
		Path source = Paths.get((String) params.get("from"));
		Path target = Paths.get((String) params.get("to"));
		try {
			Files.copy(source, target);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean fileExists(HashMap<String, Object> params) {
		File file = new File((String) params.get("path"));
		return file.exists();
	}

	@Override
	public void createFolder(HashMap<String, Object> params) {
		String path = (String) params.get("path");
		Path dirPath = Paths.get(path);

		try {
			Files.createDirectory(dirPath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
