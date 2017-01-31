package loader;

import levelObjects.*;
import levelObjects.Object;
import levels.Level;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MyTextLevelLoader implements LevelLoader{
	
	BufferedReader reader;
	
	@Override
	public Level loadLevel(InputStream input) throws IOException{
		
		this.reader = new BufferedReader(new InputStreamReader(input));
		ArrayList<ArrayList<Object>> levelMap = new ArrayList<ArrayList<Object>>();
		ArrayList<ArrayList<Object>> targetMap = new ArrayList<ArrayList<Object>>();
		
		String line;
		int i=0;
		int j=0;
		char c;
		
		while ((line = reader.readLine()) != null) 
		{
			levelMap.add(new ArrayList<Object>());
			targetMap.add(new ArrayList<Object>());
			for (j=0;j<line.length();j++)
			{
				c= line.charAt(j);
				switch (c){
				case '@':
					levelMap.get(i).add(j, new BoxObject(new Place(i,j)));
					targetMap.get(i).add(j, new FloorObject(new Place(i,j)));
					break;
				case 'A':
					levelMap.get(i).add(j, new CharacterObject(new Place(i,j)));
					targetMap.get(i).add(j, new FloorObject(new Place(i,j)));
					break;
				case ' ':
					levelMap.get(i).add(j, new FloorObject(new Place(i,j)));
					targetMap.get(i).add(j, new FloorObject(new Place(i,j)));
					break;
				case 'o':
					levelMap.get(i).add(j, new TargetObject(new Place(i,j)));
					targetMap.get(i).add(j, new TargetObject(new Place(i,j)));
					break;
				case '#':
					levelMap.get(i).add(j, new WallObject(new Place(i,j)));
					targetMap.get(i).add(j, new FloorObject(new Place(i,j)));
					break;
				}
			}
			i++;
		}
		reader.close();
		Level level=new Level(levelMap,targetMap);
		return level;
		}
		
	}

