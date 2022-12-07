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

		// Get sorted unique symptoms list
		TreeMap<String, Integer> listOfSortedSymptoms;
		listOfSortedSymptoms = symptoms.getSortedSymptoms();

		// Write list to output file
		destFile.putSymptoms(listOfSortedSymptoms);
	}
}
