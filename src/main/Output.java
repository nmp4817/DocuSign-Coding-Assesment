package main;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Output {
	public static void printOnConsole() {
		for( ArrayList<String> result: Rules.results ) {
			String ans = "Output: ";
			for ( String s: result ) {
				ans += s +", ";
			}
			
			System.out.println(ans.substring(0,ans.length()-2)+"\n");
		}
	}
	
	public static void writeInFile() throws IOException {
		String answers = "";
		for( ArrayList<String> result: Rules.results ) {
			String ans = "Output: ";
			for ( String s: result ) {
				ans += s +", ";
			}
			
			answers += ans.substring(0,ans.length()-2)+"\n";
		}
		
		FileWriter fWriter = new FileWriter(Input.outFilePath);
		fWriter.write(answers); 
		fWriter.flush();
		fWriter.close();

	}
}
