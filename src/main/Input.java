package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class Input {
	
	InputStreamReader inReader;
	BufferedReader cmdReader,fileReader;
	FileReader fReader;
	String inFilePath, outFilePath;
	
	public Input() {
		inReader = new InputStreamReader(System.in);
		cmdReader = new BufferedReader(inReader);
		Model model = new Model();		
	}
	
	public static void main(String[] args) throws IOException {
		
		ArrayList<String[]> listOfCommandsArray;
		
		Input input = new Input();

		while ( true ) {
			
			System.out.println("\n1 Console \n2 File \n3 Exit");
			System.out.print("\nEnter Type of Input:");
			
			int c = Integer.parseInt(input.cmdReader.readLine());
			
			switch(c) {
				case 1:
					listOfCommandsArray = input.getCommandsViaCMD();
//					for (String[] s: listOfCommandsArray) {
//						System.out.println(java.util.Arrays.toString(s));
//					}
					Rules.validateCommands(listOfCommandsArray);
					Output.printOnConsole();
					break;
				case 2:
					listOfCommandsArray = input.getCommandsViaFile();
					Rules.validateCommands(listOfCommandsArray);
					Output.writeInFile(input.outFilePath);
					input.fReader.close();
					input.fileReader.close();
					break;
				case 3:
					input.inReader.close();
					input.cmdReader.close();
					System.exit(0);
					break;
				default:
					System.out.println("Please Select one of the options.\n");
					break;
			}	
		}
	}
	
	public ArrayList<String[]> getCommandsViaCMD() throws IOException {
		
		ArrayList<String[]> listOfCommandsArray = new ArrayList<String[]>();
		String line;
		
		while ((line = cmdReader.readLine()) != null) {
			if (line.length() == 0) break;
			if (line.matches("[a-zA-Z0-9, ]*"))
				listOfCommandsArray.add(line.replaceAll(",","").split(" "));
		}
		
		return listOfCommandsArray;
	}
	
public ArrayList<String[]> getCommandsViaFile() throws IOException {

		System.out.println("\nEnter path for input file:");
		inFilePath = cmdReader.readLine().trim();
		System.out.println("\nEnter path for output file:");
		outFilePath = cmdReader.readLine().trim();
		
		fReader = new FileReader(inFilePath);
		fileReader = new BufferedReader(fReader);
		
		ArrayList<String[]> listOfCommandsArray = new ArrayList<String[]>();
		String line;
		
		while ((line = fileReader.readLine()) != null) {
			if (line.length() == 0) break;
			if (line.matches("[a-zA-Z0-9, ]*"))
				listOfCommandsArray.add(line.replaceAll(",","").split(" "));
		}
		
		return listOfCommandsArray;
	}

}
