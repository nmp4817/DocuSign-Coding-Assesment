package main;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * This class implements all the rules to validate clothing commands.
 * @author Nabil
 *
 */
public class Rules {
	
	/**
	 * ArrayList results stores results for all commands.
	 * ArrayList result stores result for a single command.
	 */
	public static ArrayList<ArrayList<String>> results;
	public static ArrayList<String> result,inputList;
	
	/**
	 * ValidateCommands for clothing in different temperature. 
	 * @param listOfCommandsArray ArrayList of commands String[] provided by Input class.
	 */
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
	
	/**
	 * Checks all the rules related to HOT Temperature clothing.
	 * @param commandsArray String[] of command.
	 */
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
	
	/**
	 * Checks all the rules related to COLD Temperature clothing.
	 * @param commandsArray String[] of command.
	 */
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
	
	/**
	 * Checks is the first command Removing Pajamas.
	 * @return boolean
	 */
	public static boolean isPajamaOff() {
		if ( !inputList.get(0).equals("8") ) {
			result.add("fail");
			results.add(result);
			return false;
		}
		return true;
	}
	
	/**
	 * Checks is there repetition of any clothing item.
	 * @return boolean
	 */
	public static boolean isClothRepeatation() {
		Set<String> se = new HashSet<String>(inputList);
		if (se.size() < inputList.size()) {
			result.add("fail");
			return true;		
		}
		return false;
	}
	
	/**
	 * Checks is Socks On. Used in HOT temperature clothing validation.
	 * @return boolean
	 */
	public static boolean isSocksOn() {
		if ( inputList.get(inputList.size() - 1).equals("3") ) {
			result.add("fail");
			return true;
		}
		return false;
	}
	
	/**
	 * Checks is Jacket On. Used in HOT temperature clothing validation.
	 * @return boolean
	 */
	public static boolean isJacketOn() {
		if ( inputList.get(inputList.size() - 1).equals("5") ) {
			result.add("fail");
			return true;
		}
		return false;
	}
	
	/**
	 * Checks is Pants On Before wearing shoes. Used in both HOT and COLD temperature clothing validation.
	 * @return boolean
	 */
	public static boolean isPantsOnB4Footwear() {
		if ( !inputList.contains("6")  ) {
			result.add("fail");
			return false;
		}
		return true;
	}
	
	/**
	 * Checks is Shirt On Before Headgear. Used in both HOT and COLD temperature clothing validation.
	 * @return boolean
	 */
	public static boolean isShirtOnB4Headwear() {
		if ( !inputList.contains("4")  ) {
			result.add("fail");
			return false;
		}
		return true;
	}
	
	/**
	 * Checks Shirt On Before Jacket. Used in COLD temperature clothing validation.
	 * @return boolean
	 */
	public static boolean isShirtOnB4Jacket() {
		if ( !inputList.contains("4")  ) {
			result.add("fail");
			return false;
		}
		return true;
	}
	
	/**
	 * Checks Socks On Before Shoes. Used in COLD temperature clothing validation.
	 * @return boolean
	 */
	public static boolean isSocksOnB4Shoes() {
		if ( !inputList.contains("3")  ) {
			result.add("fail");
			return false;
		}
		return true;
	}
	
	/**
	 * Checks before leaving house all clothing are On.
	 * @return boolean
	 */
	public static boolean isAllClothingsOn() {
		if ( inputList.size() != 6 && inputList.size() != 8 ) {
			result.add("fail");
			return false;
		}
		return true;
	}
	
	/**
	 * Return AraayList of Results.
	 * @return ArrayList
	 */
	public static ArrayList<ArrayList<String>> getResults() {
		if (Rules.results != null) {
			 return Rules.results;
		} else {
			return new ArrayList<ArrayList<String>>();
		}
	}
}
