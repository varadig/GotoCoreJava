package core.filesystem.version;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.HashMap;

import core.filesystem.base.CoreBaseFileSytem;

public class CoreFileSystemJava6 extends CoreBaseFileSytem {

	@Override
	public void appendTextFile(HashMap<String, Object> params) {
		try {
			PrintWriter out = new PrintWriter(new BufferedWriter(
					new FileWriter((String) params.get("path"), true)));
			out.println((String) params.get("content"));
			out.close();
		} catch (IOException e) {

		}
	}

	@Override
	public void deleteFile(HashMap<String, Object> params) {
		String path = (String) params.get("path");
		// A File object to represent the filename
		File file = new File(path);

		// Make sure the file or directory exists and isn't write protected
		if (!file.exists())
			throw new IllegalArgumentException(
					"Delete: no such file or directory: " + path);

		if (!file.canWrite())
			throw new IllegalArgumentException("Delete: write protected: "
					+ path);

		// If it is a directory, make sure it is empty
		if (file.isDirectory()) {
			String[] files = file.list();
			if (files.length > 0)
				throw new IllegalArgumentException(
						"Delete: directory not empty: " + path);
		}
		file.delete();
	}

	@Override
	public Object readBinaryFile(HashMap<String, Object> params) {

		File file = new File((String) params.get("path"));
		String s = null;
		try
		{
			InputStream insputStream = new FileInputStream(file);
			long length = file.length();
			byte[] bytes = new byte[(int) length];

			insputStream.read(bytes);
			insputStream.close();

			s = new String(bytes);
			// Print the byte data into string format
			System.out.println(s);
		} catch (Exception e)
		{
			System.out.println("Error is:" + e.getMessage());
		}
		return s;
	}

	@Override
	public Object readTextFile(HashMap<String, Object> params) {
		try
		{
			return readFile((String)params.get("path"));
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	private String readFile(String path) throws IOException
	{
		 BufferedReader br = new BufferedReader(new FileReader(path));
		 String line = null;
		 String everything=null;
		    try {
		        StringBuilder sb = new StringBuilder();
		        line = br.readLine();

		        while (line != null) {
		            sb.append(line);
		            sb.append("\n");
		            line = br.readLine();
		        }
		         everything = sb.toString();
		    } finally {
		        br.close();
		    }
		    return everything;
		
	}

	@Override
	public void createTextFile(HashMap<String, Object> params) {
		Writer output = null;
		String text = (String)params.get("content");
		File file = new File((String)params.get("path"));
		try
		{
			output = new BufferedWriter(new FileWriter(file));
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try
		{
			output.write(text);
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try
		{
			output.close();
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Your file has been written");	}

	@Override
	public void copyFile(HashMap<String, Object> params) {
		try{
			  File from = new File((String)params.get("from"));
			  File to = new File((String)params.get("to"));

			  InputStream in = new FileInputStream(from);
			  OutputStream out = new FileOutputStream(to);

			  byte[] buf = new byte[1024];
			  int len;
			  while ((len = in.read(buf)) > 0){
			  out.write(buf, 0, len);
			  }
			  in.close();
			  out.close();
			  System.out.println("File copied.");
			  }
			  catch(FileNotFoundException ex){
			  System.out.println(ex.getMessage() + " in the specified directory.");
			  System.exit(0);
			  }
			  catch(IOException e){
			  System.out.println(e.getMessage());  
			  }		
	}

	@Override
	public boolean fileExists(HashMap<String, Object> params) {
		File file = new File((String)params.get("path"));
		return file.exists();
	}

	@Override
	public void createFolder(HashMap<String, Object> params) {
		File from = new File((String)params.get("from"));
		  File to = new File((String)params.get("to"));

  	//make sure source exists
  	if(!from.exists()){

         System.out.println("Directory does not exist.");
         //just exit
         System.exit(0);

      }else{

         try{
      	copyFolder(from,to);
         }catch(IOException e){
      	e.printStackTrace();
      	//error, just exit
              System.exit(0);
         }
      }

  	System.out.println("Done");
	}
	
	public static void copyFolder(File src, File dest) throws IOException
	{

		if (src.isDirectory())
		{

			// if directory not exists, create it
			if (!dest.exists())
			{
				dest.mkdir();
				System.out.println("Directory copied from " + src + "  to "
						+ dest);
			}

			// list all the directory contents
			String files[] = src.list();

			for (String file : files)
			{
				// construct the src and dest file structure
				File srcFile = new File(src, file);
				File destFile = new File(dest, file);
				// recursive copy
				copyFolder(srcFile, destFile);
			}

		} else
		{
			// if file, then copy it
			// Use bytes stream to support all file types
			InputStream in = new FileInputStream(src);
			OutputStream out = new FileOutputStream(dest);

			byte[] buffer = new byte[1024];

			int length;
			// copy the file content in bytes
			while ((length = in.read(buffer)) > 0)
			{
				out.write(buffer, 0, length);
			}

			in.close();
			out.close();
			System.out.println("File copied from " + src + " to " + dest);
		}
	}
}
