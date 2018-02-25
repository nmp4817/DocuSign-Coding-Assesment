package main;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Rules {
	
	ArrayList<ArrayList<String>> results = new ArrayList<ArrayList<String>>();
	ArrayList<String> result,inputList;
	
	public ArrayList<ArrayList<String>> validateCommands(ArrayList<String[]> listOfCommandsArray) {
		
		for ( String[] commandsArray: listOfCommandsArray ) {
			
			result = new ArrayList<String>();
			inputList = new ArrayList<String>();
			
			if ( commandsArray.length < 2) {
				result.add("fail");
				results.add(result);
				continue;
			}
			
			if ( !commandsArray[1].equals("8") ) {
				result.add("fail");
				results.add(result);
				continue;
			}
			
			result.add("Removing PJs");
			
			if ( commandsArray[0].toUpperCase().equals("HOT") ) {
				checkForHOTTemperature(commandsArray);
			}
		}
		
		return results;
			
	}
	
	public void checkForHOTTemperature(String[] commandsArray) {
		
		inputList.add("8");
		
		for (int i = 2; i < commandsArray.length; i++ ) {
			
			inputList.add(commandsArray[i]);
			
			if ( checkClothRepeatation() ) break;
			
		}
		
		results.add(result);
	}
	
	public boolean checkClothRepeatation() {
		Set<String> se = new HashSet<String>(inputList);
		if (se.size() < inputList.size()) {
			result.add("fail");
			return true;		
		}
		return false;
	}
	
}
