package displayer;
import java.util.ArrayList;
import levels.Level;
import levelObjects.Object;

public class MyLevelDisplayer implements LevelDisplayer{
	Level level = null;

	public MyLevelDisplayer(Level level) {
		this.level = level;
	}

	public void display() {

		for (ArrayList<Object> map : level.getLevelMap()) {
			for (Object inst : map)
				System.out.print(inst.toString());
			System.out.println();
		}
	}
}