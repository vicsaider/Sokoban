package saver;

import java.io.OutputStream;

import levels.Level;

import java.io.IOException;

public interface LevelSaver {
	void saveLevel(Level level, OutputStream output) throws IOException;
}
