package saver;

import java.io.IOException;
import java.io.OutputStream;
import java.io.ObjectOutputStream;

import levels.Level;

public class MyObjectLevelSaver implements LevelSaver {
	
	public void saveLevel(Level level, OutputStream output) throws IOException {
		try 
		{
			 ObjectOutputStream out = new ObjectOutputStream(output);
			 out.writeObject(level);
			 out.close();
		} 
		catch (IOException e) {e.printStackTrace();}
	}


}
