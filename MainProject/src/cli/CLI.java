package cli;

import java.io.IOException;
import java.util.Scanner;

import commands.DisplayCommand;
import commands.ExitCommand;
import commands.LoadCommand;
import commands.MoveCommand;
import commands.SaveCommand;
import levels.Level;
import mover.Direction;
import policy.MySokobanPolicy;

public class CLI {
	
    
	protected boolean exit = false;
	protected String[] input;
	protected Level level;
	protected MySokobanPolicy policy;
	protected Direction direction;
	protected DisplayCommand displayCommand;
	protected ExitCommand exitCommand;
	protected LoadCommand loadCommand;
	protected MoveCommand moveCommand;
	protected SaveCommand saveCommand;
	protected Scanner sc = new Scanner(System.in);

	
	public CLI(){}
	
    public CLI(String[] input) {
        this.input = input;
    }
	
    void run() throws IOException {
    	
        System.out.println("--------Sokoban Game----------");
        System.out.println("Game commands:");
        System.out.println("\"load filepath\" to load level from file");
        System.out.println("\"save filepath\" to save level to file");
        System.out.println("\"move {up,down,left,right}\" to move the character");
        System.out.println("\"display\" to display the level");
        System.out.println("\"exit\" to exit");
        System.out.println("\n");
        while (!exit) {
        	input = sc.nextLine().split(" ");
            System.out.println(input);
            switch (input[0]) {
                case "load":
                    load(input[1]);
                    break;
                case "save":
                    save(input[1]);
                    break;
                case "display":
                    display();
                    break;
                case "exit":
                    exit();
                    break;
                case "move":
                	switch(input[1]){
                		case "up":
                			move(Direction.UP);
                			break;
                		case "down":
                			move(Direction.DOWN);
                			break;
                		case "left":
                			move(Direction.LEFT);
                			break;
                		case "right":
                			move(Direction.RIGHT);
                			break;
                	}
                	break;
                default:
                    System.out.println("Invalid command.");
                    break;
            }
        }

    }

        
    	
	private void load(String path) throws IOException {
		
		loadCommand = new LoadCommand(path);
		loadCommand.execute();
		if (loadCommand.getLevel() == null){
			System.out.println("Failed to load level");
			return;
		}
		level = loadCommand.getLevel();
		System.out.println("Loaded level");	
		displayCommand = new DisplayCommand(level);
		displayCommand.execute();
	}
	
	private void save(String path) throws IOException {
		
		if (level == null){
			System.out.println("No level to save.");
			return;
		}
		saveCommand = new SaveCommand(path,level);
		saveCommand.execute();
		System.out.println("Level saved successfully.");
	}
    
	private void display() {
		if(displayCommand == null)
		{
			System.out.println("No level loaded.");
			return;
		}
		System.out.println("Displaying level.");
		displayCommand.execute();
	}
	
	private void move(Direction moveDirection) throws IOException {
		direction = moveDirection;
		if (level == null){
			System.out.println("No level loaded.");
			return;
		}
		policy = new MySokobanPolicy(level, direction);
		moveCommand = new MoveCommand(level,policy, direction);
		moveCommand.execute();
		System.out.println("Move executed.");
		displayCommand.execute();
	}
    
    
	
	private void exit() {
		
		exitCommand = new ExitCommand();
		System.out.println("Program terminated, exiting.");
		exit = true;
		exitCommand.execute();
		
	}
	
	public boolean isExit() {
        return exit;
    }
}
