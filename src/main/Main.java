package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class Main {
	
	static InputStreamReader inReader = new InputStreamReader(System.in);
	static BufferedReader cmdReader,fileReader;
	
	public static void main(String[] args) throws IOException {
		
		ArrayList<String[]> listOfCommandsArray;
		ArrayList<ArrayList<String>> results;
		
		cmdReader = new BufferedReader(inReader);
		
		Model model = new Model();
		Rules rules = new Rules();
		
		while ( true ) {
			
			System.out.println("1 CMD \n2 File \n3 Exit");
			System.out.print("\nEnter Type of Input:");
			
			int c = Integer.parseInt(cmdReader.readLine());
			
			switch(c) {
				case 1:
					listOfCommandsArray = getCommandsViaCMD();
					results = rules.validateCommands(listOfCommandsArray);
					break;
				case 2:
					break;
				case 3:
					inReader.close();
					cmdReader.close();
					System.exit(0);
					break;
				default:
					System.out.println("Please Select one of the options.\n");
					break;
			}	
		}
	}
	
	public static ArrayList<String[]> getCommandsViaCMD() throws IOException {
		
		ArrayList<String[]> listOfCommandsArray = new ArrayList<String[]>();
		String line = cmdReader.readLine();
		
		while ((line = cmdReader.readLine()) != null) {
			if (line.length() == 0) break;
			if (line.matches("[a-zA-Z0-9, ]*"))
				listOfCommandsArray.add(line.replaceAll(",","").split(" "));
		}
		
		return listOfCommandsArray;
	}

}
