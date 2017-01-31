package commands;

import saver.*;
import levels.Level;
import java.util.HashMap;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class SaveCommand implements Command{
	
	private HashMap<String,LevelSaver> levelSavers;
	private String path;
	private String type;
	private Level level;
	
	public void setPath(String path){
		this.path=path;
	}
	
	public String getPath(){
		return path;
	}
	
	public SaveCommand(){}
	
	public SaveCommand(String path, Level level){
		this.level=level;
		this.levelSavers = new HashMap<String,LevelSaver>();
		this.type = path.substring(path.lastIndexOf('.') + 1);
		this.setPath(path);
		this.levelSavers.put("txt", new MyTextLevelSaver());
		this.levelSavers.put("obj", new MyObjectLevelSaver());
		this.levelSavers.put("xml", new MyXMLLevelSaver());
	}
	
	public void execute() throws IOException{
		
		if (type.equals("txt") || type.equals("obj") || type.equals("xml")){
			try
			{
			levelSavers.get(type).saveLevel(this.level,new FileOutputStream(path));
			System.out.println("Level was saved successfully.");
			}
			catch (FileNotFoundException e)
			{
				System.out.println(e.getMessage());
			} 
			catch (IOException e)
			{
				System.out.println(e.getMessage());
			}
		}
		else
		{
			System.out.println("Invalid file path");
		}
	}
	
}