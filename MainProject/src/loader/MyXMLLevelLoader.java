package loader;

import java.beans.XMLDecoder;
import java.io.IOException;
import java.io.InputStream;

import levels.Level;

public class MyXMLLevelLoader implements LevelLoader{
	
	public Level loadLevel(InputStream input) throws IOException {

		XMLDecoder decoder = new XMLDecoder(input);
		Level level = (Level)decoder.readObject();
		decoder.close();
		return level;
	}
	
	
	
}
