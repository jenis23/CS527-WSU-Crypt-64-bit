package wsu;
import java.util.*;
import java.io.*;

public class test {

    public static void main(String[] args) {

		try {
	
			// create our map of lowercase letters to integers
			Hashtable<String, Double> freq = new Hashtable<String, Double>();
			String set = "abcdefghijklmnopqrstuvwxyz";
		
			int count = 0;
	
			// initialize our character counts to 0
			for ( int i = 0; i < set.length(); i++) {
				freq.put(set.substring(i, i+1), 0.0);
			}
	
			// open our file
			BufferedReader in = new BufferedReader(new FileReader("d:/string.txt"));
			String line;
	
			// read in each line from the file
			while ( (line = in.readLine()) != null) {
			
				// extract each character from the line
				for (int i = 0; i < line.length(); i++) {
					String c = line.substring(i, i+1);
					
					// try and match our character to a lower or upper case letter
					if (c.matches("[a-zA-Z]")) {
					
						// increment the count of our character
						c = c.toLowerCase();
						freq.put(c, freq.get(c) + 1.0);
						count++;
					}
				}
			}
			
			// calculate the frequency of each of our characters, printing the result
			for (int i = 0; i < set.length(); i++) {
				String key = set.substring(i, i + 1);
				double perc = freq.get(key) / count * 100.0;
				System.out.println(key + ": " + String.format("%2.2f", perc));
			}
			
			System.out.println(Arrays.toString(
				    set.split("(?<=\\G.{2})")
				));
			
		} catch (IOException ioe) {
		
			// catch any problems we have reading the file from disk
			ioe.printStackTrace();
		}
    }
}