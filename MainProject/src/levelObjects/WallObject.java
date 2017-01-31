package levelObjects;

import java.io.Serializable;

@SuppressWarnings("serial")
public class WallObject extends LevelObject implements Serializable{
	
	public WallObject() {
		this.presentPlace=null;
	}
	
	public WallObject(Place place) {
		this.presentPlace=place;
	}

	@Override
	public String toString() {
        return "#";
    }

}
