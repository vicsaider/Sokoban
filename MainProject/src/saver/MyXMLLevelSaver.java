package saver;

import java.beans.XMLEncoder;
import java.io.IOException;
import java.io.OutputStream;

import levels.Level;

public class MyXMLLevelSaver implements LevelSaver{
	
	public void saveLevel(Level level, OutputStream output) throws IOException {

		XMLEncoder encoder = new XMLEncoder(output);
		encoder.writeObject(level);
		encoder.close();
	}
	
	
	
}
