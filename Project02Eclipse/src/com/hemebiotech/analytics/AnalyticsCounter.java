package com.hemebiotech.analytics;

import java.util.*;

public class AnalyticsCounter {
	public static void main(String[] args) {
		// Input and output files

		ReadSymptomDataFromFile sourceFile = new ReadSymptomDataFromFile("symptoms.txt");
		WriteSymptomDataToFile destFile = new WriteSymptomDataToFile("result.out");

		// Get raw symptoms list, as declared in input
		List<String> rawSymptoms = sourceFile.getSymptoms();
		Symptoms symptoms = new Symptoms(rawSymptoms);

		// Get unique symptoms list
		// Map<String, Integer> listOfSymptoms = symptoms.getUniqueSymptoms();

		// Get sorted unique symptoms list
		TreeMap<String, Integer> listOfSortedSymptoms;
		listOfSortedSymptoms = symptoms.getSortedSymptoms();

		// Write list to output file
		if (destFile.putSymptoms(listOfSortedSymptoms) == 0) {
			System.out.println("Unable to write output file");
		}
	}
}
