package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class AnalyticsCounter {
	private static int headacheCount = 0;	// initialize to 0 - fPIC : useless comment
	private static int rashCount = 0;		// initialize to 0 - fPIC : useless comment
	private static int pupilCount = 0;		// initialize to 0 - fPIC : useless comment
	
	public static void main(String args[]) throws Exception { // fPIC : exceptions not used in this class
		// first get input
		BufferedReader reader = new BufferedReader (new FileReader("symptoms.txt"));
		String line = reader.readLine();

		int i = 0;	// set i to 0 - fPIC : useless comment
		int headCount = 0;	// counts headaches - fPIC : difference with headacheCount ?
		while (line != null) {
			i++;	// increment i - fPIC : useless comment; unused variable
			System.out.println("symptom from file: " + line);
			if (line.equals("headache")) {
				headCount++;
				System.out.println("number of headaches: " + headCount);
			}
			else if (line.equals("rush")) {
				rashCount++;
			}
			else if (line.contains("pupils")) { // fPIC : testing substring match, could result in inaccuracy in result
				pupilCount++;
			}

			line = reader.readLine();	// get another symptom
		}
		
		// next generate output - opening, closing not tested for exceptions
		FileWriter writer = new FileWriter ("result.out");
		writer.write("headache: " + headacheCount + "\n"); // fPIC : variable not modified in previous code, resulting in original bug
		writer.write("rash: " + rashCount + "\n");
		writer.write("dialated pupils: " + pupilCount + "\n"); // fPIC : inacurate result, matches dialated pupils AND constricted pupils
		writer.close();
	}
}
