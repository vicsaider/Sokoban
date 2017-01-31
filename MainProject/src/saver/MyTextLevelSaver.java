package saver;

import levelObjects.Object;
import levels.Level;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class MyTextLevelSaver implements LevelSaver{
	
	BufferedWriter writer;
	
	public void saveLevel(Level level, OutputStream output) throws IOException{
		
		this.writer = new BufferedWriter(new OutputStreamWriter(output));
		
		for (ArrayList<Object> map : level.getLevelMap()) {
			for (Object inst : map)
				writer.write(inst.toString());
			writer.newLine();
		}
		writer.close();
		}
		
	}
