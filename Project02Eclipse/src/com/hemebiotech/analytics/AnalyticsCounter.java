package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AnalyticsCounter {
	private static int headacheCount = 0;
	private static int rashCount = 0;
	private static int pupilCount = 0;

	public static void main(String[] args) throws Exception {
		// Initialize the source data
		ReadSymptomDataFromFile sourceFile = new ReadSymptomDataFromFile("symptoms.txt");

		// Get the raw data from source
		List<String> rawSymptoms = sourceFile.getSymptoms();

		// Get list of unique symptoms
		Symptoms symptoms = new Symptoms(rawSymptoms);
		Map<String, Integer> uniqueSymptoms = symptoms.getUniqueSymptoms();

		TreeMap<String, Integer> sortedSymptoms = symptoms.getSortedSymptoms();


		sortedSymptoms.forEach((key, value) -> System.out.println(key + ":" + value));
		
		//
		// OLD
		//

		// first get input
		BufferedReader reader;
		String line;

		try {
			reader = new BufferedReader(new FileReader("symptoms.txt"));
			line = reader.readLine();

			while (line != null) {

				if (line.equals("headache")) {
					headacheCount++;
				} else if (line.equals("rash")) {
					rashCount++;
				} else if (line.equals("dialated pupils")) {
					pupilCount++;
				}

				line = reader.readLine(); // get another symptom
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		// next generate output
		FileWriter writer;

		try {
			writer = new FileWriter("result.out");
			writer.write("headache: " + headacheCount + "\n");
			writer.write("rash: " + rashCount + "\n");
			writer.write("dialated pupils: " + pupilCount + "\n");
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
