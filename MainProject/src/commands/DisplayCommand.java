package commands;

import levels.Level;
import displayer.MyLevelDisplayer;

public class DisplayCommand implements Command {
	MyLevelDisplayer displayer = null;
	
	public DisplayCommand(){}
		
	public DisplayCommand(Level level){
		displayer=new MyLevelDisplayer(level);
	}
	
	public void execute(){
		displayer.display();
	}
	
}
