package levelObjects;

import java.io.Serializable;

@SuppressWarnings("serial")
public class FloorObject extends LevelObject implements Serializable{
	
	public FloorObject() {
		this.presentPlace=null;
	}
	
	public FloorObject(Place place) {
		this.presentPlace=place;
	}
	
	@Override
	public String toString() {
        return " ";
    }


}
