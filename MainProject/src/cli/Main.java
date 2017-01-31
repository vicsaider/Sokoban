package cli;

import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		CLI cli = new CLI();
		
		while (!cli.isExit()){
			try {
	            cli.run();
	        } 
			catch (IOException e) {
	            e.printStackTrace();
	        }
		}
	}

}
