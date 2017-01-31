package policy;

import java.io.IOException;

import levelObjects.Object;
import levelObjects.Place;
import levels.Level;
import mover.Direction;

public class MySokobanPolicy {
	
	protected Level level;
	protected Direction direction;
	
	public MySokobanPolicy(){}

    public MySokobanPolicy(Level level, Direction direction) throws IOException {
    	this.level=level;
		this.direction=direction;
    }
	
	public void executePolicy() {
		//current character position
				Place characterPosition = level.getCharacterPlacement();
				Place objectInDirectionPosition;
				Place objectInDirectionPosition2;
				Object objectInDirection;
				Object objectInDirection2;
				int characterX = characterPosition.getX();
				int characterY = characterPosition.getY();
				switch(direction){
				
				case UP:
					objectInDirectionPosition = new Place(characterX-1,characterY);
					objectInDirection = level.getObjectInDirection(objectInDirectionPosition, direction);
					//there is a wall
					if (objectInDirection.getObjectType().equals("class levelObjects.WallObject")){
						System.out.println("Move not possible, there is a wall");
						break;
					}
					//there is empty space to move to
					if (objectInDirection.getObjectType().equals("class levelObjects.FloorObject")){
						this.level.moveObject(characterPosition,objectInDirectionPosition);
						characterPosition = objectInDirectionPosition;
						level.changeCharacterPlacement(characterPosition);
						System.out.println("Character was moved");
						break;
					}
					//there is a box in front of character
					if (objectInDirection.getObjectType().equals("class levelObjects.BoxObject")){
						objectInDirectionPosition2 = new Place(characterX-2,characterY);
						objectInDirection2 = level.getObjectInDirection(objectInDirectionPosition2, direction);
						//there is wall after the box
						if (objectInDirection2.getObjectType().equals("class levelObjects.WallObject")){
							System.out.println("Move not possible, there is a wall after the box");
							break;
						}
						//there is box after the box
						if (objectInDirection2.getObjectType().equals("class levelObjects.BoxObject")){
							System.out.println("Move not possible, there is a box after the box");
							break;
						}
						//there is empty space after the box
						if (objectInDirection2.getObjectType().equals("class levelObjects.FloorObject")){
							this.level.moveObject(objectInDirectionPosition,objectInDirectionPosition2);
							this.level.moveObject(characterPosition,objectInDirectionPosition);
							characterPosition = objectInDirectionPosition;
							level.changeCharacterPlacement(characterPosition);
							System.out.println("Character and box were moved");
							break;
						}
					}
					break;
				case DOWN:
					objectInDirectionPosition = new Place(characterX+1,characterY);
					objectInDirection = level.getObjectInDirection(objectInDirectionPosition, direction);
					//there is a wall
					if (objectInDirection.getObjectType().equals("class levelObjects.WallObject")){
						System.out.println("Move not possible, there is a wall");
						break;
					}
					//there is empty space to move to
					if (objectInDirection.getObjectType().equals("class levelObjects.FloorObject")){
						this.level.moveObject(characterPosition,objectInDirectionPosition);
						characterPosition = objectInDirectionPosition;
						level.changeCharacterPlacement(characterPosition);
						System.out.println("Character was moved");
						break;
					}
					//there is a box in front of character
					if (objectInDirection.getObjectType().equals("class levelObjects.BoxObject")){
						objectInDirectionPosition2 = new Place(characterX+2,characterY);
						objectInDirection2 = level.getObjectInDirection(objectInDirectionPosition2, direction);
						//there is wall after the box
						if (objectInDirection2.getObjectType().equals("class levelObjects.WallObject")){
							System.out.println("Move not possible, there is a wall after the box");
							break;
						}
						//there is box after the box
						if (objectInDirection2.getObjectType().equals("class levelObjects.BoxObject")){
							System.out.println("Move not possible, there is a box after the box");
							break;
						}
						//there is empty space after the box
						if (objectInDirection2.getObjectType().equals("class levelObjects.FloorObject")){
							this.level.moveObject(objectInDirectionPosition,objectInDirectionPosition2);
							this.level.moveObject(characterPosition,objectInDirectionPosition);
							characterPosition = objectInDirectionPosition;
							level.changeCharacterPlacement(characterPosition);
							System.out.println("Character and box were moved");
							break;
						}
					}
					break;
				case LEFT:
					objectInDirectionPosition = new Place(characterX,characterY-1);
					objectInDirection = level.getObjectInDirection(objectInDirectionPosition, direction);
					//there is a wall
					if (objectInDirection.getObjectType().equals("class levelObjects.WallObject")){
						System.out.println("Move not possible, there is a wall");
						break;
					}
					//there is empty space to move to
					if (objectInDirection.getObjectType().equals("class levelObjects.FloorObject")){
						this.level.moveObject(characterPosition,objectInDirectionPosition);
						characterPosition = objectInDirectionPosition;
						level.changeCharacterPlacement(characterPosition);
						System.out.println("Character was moved");
						break;
					}
					//there is a box in front of character
					if (objectInDirection.getObjectType().equals("class levelObjects.BoxObject")){
						objectInDirectionPosition2 = new Place(characterX,characterY-2);
						objectInDirection2 = level.getObjectInDirection(objectInDirectionPosition2, direction);
						//there is wall after the box
						if (objectInDirection2.getObjectType().equals("class levelObjects.WallObject")){
							System.out.println("Move not possible, there is a wall after the box");
							break;
						}
						//there is box after the box
						if (objectInDirection2.getObjectType().equals("class levelObjects.BoxObject")){
							System.out.println("Move not possible, there is a box after the box");
							break;
						}
						//there is empty space after the box
						if (objectInDirection2.getObjectType().equals("class levelObjects.FloorObject")){
							this.level.moveObject(objectInDirectionPosition,objectInDirectionPosition2);
							this.level.moveObject(characterPosition,objectInDirectionPosition);
							characterPosition = objectInDirectionPosition;
							level.changeCharacterPlacement(characterPosition);
							System.out.println("Character and box were moved");
							break;
						}
					}
					break;
				case RIGHT:
					objectInDirectionPosition = new Place(characterX,characterY+1);
					objectInDirection = level.getObjectInDirection(objectInDirectionPosition, direction);
					//there is a wall
					if (objectInDirection.getObjectType().equals("class levelObjects.WallObject")){
						System.out.println("Move not possible, there is a wall");
						break;
					}
					//there is empty space to move to
					if (objectInDirection.getObjectType().equals("class levelObjects.FloorObject")){
						this.level.moveObject(characterPosition,objectInDirectionPosition);
						characterPosition = objectInDirectionPosition;
						level.changeCharacterPlacement(characterPosition);
						System.out.println("Character was moved");
						break;
					}
					//there is a box in front of character
					if (objectInDirection.getObjectType().equals("class levelObjects.BoxObject")){
						objectInDirectionPosition2 = new Place(characterX,characterY+2);
						objectInDirection2 = level.getObjectInDirection(objectInDirectionPosition2, direction);
						//there is wall after the box
						if (objectInDirection2.getObjectType().equals("class levelObjects.WallObject")){
							System.out.println("Move not possible, there is a wall after the box");
							break;
						}
						//there is box after the box
						if (objectInDirection2.getObjectType().equals("class levelObjects.BoxObject")){
							System.out.println("Move not possible, there is a box after the box");
							break;
						}
						//there is empty space after the box
						if (objectInDirection2.getObjectType().equals("class levelObjects.FloorObject")){
							this.level.moveObject(objectInDirectionPosition,objectInDirectionPosition2);
							this.level.moveObject(characterPosition,objectInDirectionPosition);
							characterPosition = objectInDirectionPosition;
							level.changeCharacterPlacement(characterPosition);
							System.out.println("Character and box were moved");
							break;
						}
					}
					break;
				}
				
			}
		
	}
