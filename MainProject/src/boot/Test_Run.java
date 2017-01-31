package boot;
import levels.*;
import loader.MyTextLevelLoader;

import java.io.*;

import displayer.LevelDisplayer;
import displayer.MyLevelDisplayer;

public class Test_Run {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		MyTextLevelLoader txtLoader = new MyTextLevelLoader();

		Level level = txtLoader.loadLevel(new FileInputStream("C:\\Study\\semester 4\\patam\\project\\level3.txt"));
		LevelDisplayer display = new MyLevelDisplayer(level);
		display.display();

	}

}
