package levels;

import levelObjects.FloorObject;
import levelObjects.Object;
import levelObjects.Place;
import levelObjects.TargetObject;
import mover.Direction;

import java.io.Serializable;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class Level implements Serializable{
	
	protected ArrayList<ArrayList<Object>> level2DMap; //2D level map with objects
	protected ArrayList<ArrayList<Object>> target2DMap; //2D target map(because objects may be placed over target place-boxes/player character)
	protected int levelWidth;
	protected int levelHeight;
	protected Place characterPlace;
	
	public Level(ArrayList<ArrayList<Object>> levelMap,ArrayList<ArrayList<Object>> targetMap) {
		this.level2DMap = levelMap;
		this.target2DMap = targetMap;
		this.setDimensions();
		this.setCharacterPlacement();
	}
	
	public void setLevelMap(ArrayList<ArrayList<Object>> levelMap){
		this.level2DMap = levelMap;
	}
	
	public void setTargetMap(ArrayList<ArrayList<Object>> targetMap){
		this.target2DMap = targetMap;
	}
	
	public ArrayList<ArrayList<Object>> getLevelMap() {
		return level2DMap;
	}
	
	public ArrayList<ArrayList<Object>> getTargetMap() {
		return target2DMap;
	}
	
	public void setDimensions(){
		this.levelWidth = level2DMap.size();
		this.levelHeight = level2DMap.get(0).size();
	}
	
	public int getLevelWidth(){
		return this.levelWidth;
	}
	
	public int getLevelHeight(){
		return this.levelHeight;
	}
	
	public void setCharacterPlacement(){
		for (ArrayList<Object> row : this.level2DMap){
			for (Object object : row) {
				if (object.toString().equals("A"))
					this.characterPlace = object.getPlaceCoordinates();
			}
		}
	}
	
	public Place getCharacterPlacement(){
		return this.characterPlace;
	}
	
	public void changeCharacterPlacement(Place place){
		this.characterPlace = place;
	}
	
	public Object getObject(Place place){
		return level2DMap.get((int)place.getX()).get((int)place.getY());
	}
	
	public Object getObjectInDirection(Place place, Direction direction){
		int x = place.getX();
		int y = place.getY();
		
		switch(direction){
		case UP: return level2DMap.get(x-1).get(y);
		case DOWN: return level2DMap.get(x+1).get(y);
		case LEFT: return level2DMap.get(x).get(y-1);
		case RIGHT: return level2DMap.get(x).get(y+1);
		default: return null;
		}
	}
	
	public void moveObject(Place source, Place dest){
		Object tempObject1 = level2DMap.get(source.getX()).get(source.getY());
		level2DMap.get(source.getX()).remove(source.getY());
		level2DMap.get(dest.getX()).remove(dest.getY());
		level2DMap.get(dest.getX()).add(dest.getY(),tempObject1);
		level2DMap.get(dest.getX()).get(dest.getY()).setPlaceCoordinates(dest);
		if (target2DMap.get(source.getX()).get(source.getY()).getObjectType().equals("TargetObject"))
			level2DMap.get(source.getX()).add(source.getY(),new TargetObject(new Place(source.getX(),source.getY())));
		else
			level2DMap.get(source.getX()).add(source.getY(),new FloorObject(new Place(source.getX(),source.getY())));
	}
	
	
}
