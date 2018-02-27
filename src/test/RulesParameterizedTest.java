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

@RunWith(Parameterized.class)
@ExtendWith(ArrayListInputParameterResolver.class)
class RulesParameterizedTest {
	
	private ArrayList<String[]> input;
	private ArrayList<ArrayList<String>> output;
	
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
	
	
	@Test
	public void testValidateCommands_success() {
		Rules.validateCommands(input);
		assertEquals(output,Rules.getResults());
	}
}
