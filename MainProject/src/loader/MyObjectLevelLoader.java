package loader;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;

import levels.Level;

public class MyObjectLevelLoader implements LevelLoader {
	
	public Level loadLevel(InputStream input) throws IOException {
		try 
		{
			Level level = (Level)(((ObjectInputStream)input).readObject());
			return level;
		} 
		catch (ClassNotFoundException e) {e.printStackTrace();}
		catch (IOException e) {e.printStackTrace();}
		return null;
	}
}
