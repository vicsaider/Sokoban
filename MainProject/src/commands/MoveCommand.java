package commands;

import java.io.IOException;

import levels.Level;
import mover.Direction;
import policy.MySokobanPolicy;

public class MoveCommand implements Command{

	protected Level level;
	protected MySokobanPolicy policy;
	protected Direction direction;
	
	public MoveCommand(){}
	
    public MoveCommand(Level level, MySokobanPolicy policy, Direction direction) throws IOException {
    	this.level=level;
		this.direction=direction;
		this.policy=policy;
		
    }
    
    @Override
    public void execute() throws IOException {
        policy.executePolicy();
    }

	
	
	
}
