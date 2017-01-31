package levelObjects;

//Abstract class for being inherited by any object that may appear in the level
public abstract class LevelObject implements Object{
	
	Place presentPlace;
	
	public String getObjectType(){
		return this.getClass().toString();
	}
	
	public Place getPlaceCoordinates(){
		return presentPlace;
	}
	
	public void setPlaceCoordinates(Place place){
		this.presentPlace=place;
	}

}
