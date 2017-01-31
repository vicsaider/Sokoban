package levelObjects;

import java.io.Serializable;

@SuppressWarnings("serial")
public class TargetObject extends LevelObject implements Serializable {

	public TargetObject() {
		this.presentPlace=null;
	}
	
	public TargetObject(Place place) {
		this.presentPlace=place;
	}
	
	@Override
	public String toString() {
		return "o";
	}
}
