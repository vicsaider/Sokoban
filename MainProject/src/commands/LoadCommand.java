package commands;

import loader.*;
import levels.Level;
import java.util.HashMap;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class LoadCommand implements Command{
	
	private HashMap<String,LevelLoader> levelLoaders;
	private String path;
	private String type;
	private Level level;
	
	public void setPath(String path){
		this.path=path;
	}
	
	public String getPath(){
		return path;
	}
	
	public LoadCommand(){}
	
	public Level getLevel(){
		return this.level;
	}
	
	public LoadCommand(String path){
		this.levelLoaders = new HashMap<String,LevelLoader>();
		this.type = path.substring(path.lastIndexOf('.') + 1);
		this.setPath(path);
		this.levelLoaders.put("txt", new MyTextLevelLoader());
		this.levelLoaders.put("obj", new MyObjectLevelLoader());
		this.levelLoaders.put("xml", new MyXMLLevelLoader());
	}
	
	public void execute() throws IOException{
		
		if (type.equals("txt") || type.equals("obj") || type.equals("xml")){
			try
			{
			this.level = levelLoaders.get(type).loadLevel(new FileInputStream(path));
			System.out.println("Level was loaded successfully.");
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
