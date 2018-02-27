package main;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * This class is responsible for outputting the results.
 * 
 * @author Nabil
 *
 */

public class Output {
	
	/**
	 * Output results on console.
	 */
	public static void printOnConsole() {
		for( ArrayList<String> result: Rules.results ) {
			String ans = "Output: ";
			for ( String s: result ) {
				ans += s +", ";
			}
			
			System.out.println(ans.substring(0,ans.length()-2)+"\n");
		}
	}
	
	/**
	 * Output results in given output file.
	 * @param outFilePath Output File path.
	 * @throws IOException Might Throw IOException since uses BufferedREader.
	 */
	public static void writeInFile(String outFilePath) throws IOException {
		String answers = "";
		for( ArrayList<String> result: Rules.results ) {
			String ans = "Output: ";
			for ( String s: result ) {
				ans += s +", ";
			}
			
			answers += ans.substring(0,ans.length()-2)+"\n";
		}
		
		FileWriter fWriter = new FileWriter(outFilePath);
		fWriter.write(answers); 
		fWriter.flush();
		fWriter.close();

	}
}
