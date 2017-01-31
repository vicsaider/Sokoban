package levelObjects;

import java.io.Serializable;

@SuppressWarnings("serial")
public class CharacterObject extends LevelObject implements Serializable{
	
	public CharacterObject() {
		this.presentPlace=null;
	}
	
	public CharacterObject(Place place) {
		this.presentPlace=place;
	}
	
	@Override
	public String toString() {
        return "A";
    }

}
