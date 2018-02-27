package main;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Rules {
	
	public static ArrayList<ArrayList<String>> results;
	public static ArrayList<String> result,inputList;
	
	public static void validateCommands(ArrayList<String[]> listOfCommandsArray) {
		
		results =  new ArrayList<ArrayList<String>>();
		
		for ( String[] commandsArray: listOfCommandsArray ) {
			
			result = new ArrayList<String>();
			inputList = new ArrayList<String>();
			
			if ( commandsArray.length < 2) {
				result.add("fail");
				results.add(result);
				continue;
			}
						
			if ( commandsArray[0].toUpperCase().equals("HOT") ) {
				checkForHOTTemperature(commandsArray);
			} else if (commandsArray[0].toUpperCase().equals("COLD") ) {
				checkForCOLDTemperature(commandsArray);
			} else {
				result.add("fail");
			}
		}	
	}
	
	public static void checkForHOTTemperature(String[] commandsArray) {
		
		inputList.add(commandsArray[1]);
		
		if ( !isPajamaOff() ) return;		
		result.add("Removing PJs");
		
		for (int i = 2; i < commandsArray.length; i++ ) {
			
			inputList.add(commandsArray[i]);
			
			if ( isClothRepeatation() ) break;
			if ( isSocksOn() ) break;
			if ( isJacketOn() ) break;
			if ( commandsArray[i].equals("1") && !isPantsOnB4Footwear() ) break;
			if ( commandsArray[i].equals("2") && !isShirtOnB4Headwear() ) break;
			if ( commandsArray[i].equals("7") && !isAllClothingsOn() ) break;
			
			result.add(Model.HOT_MAP.get(Integer.parseInt(commandsArray[i])));
		}
		
		results.add(result);
	}
	
public static void checkForCOLDTemperature(String[] commandsArray) {
		
		inputList.add(commandsArray[1]);
		
		if ( !isPajamaOff() ) return;		
		result.add("Removing PJs");
		
		for (int i = 2; i < commandsArray.length; i++ ) {
			
			inputList.add(commandsArray[i]);
			
			if ( isClothRepeatation() ) break;
			if ( commandsArray[i].equals("1") && (!isPantsOnB4Footwear() || !isSocksOnB4Shoes()) ) break;
			if ( commandsArray[i].equals("5") && !isShirtOnB4Jacket() ) break;
			if ( commandsArray[i].equals("2") && !isShirtOnB4Headwear() ) break;
			if ( commandsArray[i].equals("7") && !isAllClothingsOn() ) break;
			
			result.add(Model.COLD_MAP.get(Integer.parseInt(commandsArray[i])));
		}
		
		results.add(result);
	}
		
	public static boolean isPajamaOff() {
		if ( !inputList.get(0).equals("8") ) {
			result.add("fail");
			results.add(result);
			return false;
		}
		return true;
	}
	
	public static boolean isClothRepeatation() {
		Set<String> se = new HashSet<String>(inputList);
		if (se.size() < inputList.size()) {
			result.add("fail");
			return true;		
		}
		return false;
	}
	
	public static boolean isSocksOn() {
		if ( inputList.get(inputList.size() - 1).equals("3") ) {
			result.add("fail");
			return true;
		}
		return false;
	}
	
	public static boolean isJacketOn() {
		if ( inputList.get(inputList.size() - 1).equals("5") ) {
			result.add("fail");
			return true;
		}
		return false;
	}
	
	public static boolean isPantsOnB4Footwear() {
		if ( !inputList.contains("6")  ) {
			result.add("fail");
			return false;
		}
		return true;
	}
	
	public static boolean isShirtOnB4Headwear() {
		if ( !inputList.contains("4")  ) {
			result.add("fail");
			return false;
		}
		return true;
	}
	
	public static boolean isShirtOnB4Jacket() {
		if ( !inputList.contains("4")  ) {
			result.add("fail");
			return false;
		}
		return true;
	}
	
	public static boolean isSocksOnB4Shoes() {
		if ( !inputList.contains("3")  ) {
			result.add("fail");
			return false;
		}
		return true;
	}
	
	public static boolean isAllClothingsOn() {
		if ( inputList.size() != 6 && inputList.size() != 8 ) {
			result.add("fail");
			return false;
		}
		return true;
	}
	
	public static ArrayList<ArrayList<String>> getResults() {
		if (Rules.results != null) {
			 return Rules.results;
		} else {
			return new ArrayList<ArrayList<String>>();
		}
	}
}
