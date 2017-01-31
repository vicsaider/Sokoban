package levelObjects;

import java.io.Serializable;

@SuppressWarnings("serial")
public class BoxObject extends LevelObject implements Serializable{
	
	public BoxObject() {
		this.presentPlace=null;
	}
	
	public BoxObject(Place place) {
		this.presentPlace=place;
	}
	
	@Override
	public String toString() {
        return "@";
    }
	

}
