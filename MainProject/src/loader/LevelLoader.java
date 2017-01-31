package loader;

import java.io.InputStream;

import levels.Level;

import java.io.IOException;

public interface LevelLoader {
	Level loadLevel(InputStream input) throws IOException;
	
}

/*
A: LevelLoader is interface responsible for loading the level. The different loading will be implemented 
by implementing the LevelLoader in different ways.
The level itself is stored in Level.
B: It is possible to create different ways to load a level, from different inputs/files, without changing the class Level itself.
C: Because of using the interface LeveLoader - each new way of loading a level has to implement it. 
We will be able to use any implementation later, depending on what input of leel we will get.
D: Using InputStream gives us more flexibility. That way we will be able to implement loading from any input stream and not just from filename.
*/