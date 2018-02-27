package test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import main.Model;
import main.Rules;

/**
 * Testing validateCommands() Method of Rules class. Used Parameterized Testing.
 * @author Nabil
 *
 */

@RunWith(Parameterized.class)
@ExtendWith(ArrayListInputParameterResolver.class)
class RulesParameterizedTest {
	
	/**
	 * ArraayList of input commands and expected output results.
	 */
	private ArrayList<String[]> input;
	private ArrayList<ArrayList<String>> output;
	
	/**
	 * Constructor initializes input and expected output.
	 * @param input ArrayList of input commands.
	 */
	public RulesParameterizedTest(ArrayList<String[]> input) {
		this.input = input;
		
		ArrayList<String> output1 = new ArrayList<String>() { 
			/**
			 * 
			 */
			private static final long serialVersionUID = 3342628847803073647L;

			{
				add("Removing PJs");
				add("shorts");
				add("t-shirt");
				add("sun visor");
				add("sandals");
				add("leaving house");
			} 
		};
		
		ArrayList<String> output2 = new ArrayList<String>() { 
			/**
			 * 
			 */
			private static final long serialVersionUID = -9115874080275095375L;

			{
				add("Removing PJs");
				add("pants");
				add("socks");
				add("shirt");
				add("hat");
				add("jacket");
				add("boots");
				add("leaving house");
			} 
		};
		
		ArrayList<String> output3 = new ArrayList<String>() { 

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			{
				add("Removing PJs");
				add("shorts");
				add("fail");
			} 
		};
		
		ArrayList<String> output4 = new ArrayList<String>() { 

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			{
				add("Removing PJs");
				add("pants");
				add("socks");
				add("shirt");
				add("hat");
				add("jacket");
				add("fail");
			} 
		};
		
		this.output = new ArrayList<ArrayList<String>>() { 
			/**
			 * 
			 */
			private static final long serialVersionUID = 7967782436357779348L;

			{add(output1); add(output2);add(output3); add(output4);} 
		};
		
		Model model = new Model();
	}
	
	/**
	 * Setting up input parameters to pass to validateCommand() Method.
	 * @return ArrayList
	 */
	@Parameters
	public static Collection<Object> testConditions() {
		String[] input1 = {"HOT", "8", "6", "4", "2", "1", "7"};
		String[] input2 = {"COLD", "8", "6", "3", "4", "2", "5", "1", "7"};
		String[] input3 = {"HOT", "8", "6", "6"};
		String[] input4 = {"COLD", "8", "6", "3", "4", "2", "5", "7"};
		
		Object expectedOutputs[] = { 
					new ArrayList<String[]>() { 

					/**
						 * 
						 */
						private static final long serialVersionUID = 2312188184521190612L;

					{add(input1); add(input2); add(input3); add(input4);} }
				};
		return Arrays.asList(expectedOutputs);
	}
	
	/**
	 * Tests validateCommands() method of Rules class.
	 */
	@Test
	public void testValidateCommands() {
		Rules.validateCommands(input);
		assertEquals(output,Rules.getResults());
	}
}
