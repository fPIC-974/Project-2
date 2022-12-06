package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class AnalyticsCounter {
	private static int headacheCount = 0;
	private static int rashCount = 0;
	private static int pupilCount = 0;

	public static void main(String[] args) throws Exception {
		// first get input
		BufferedReader reader = null;
		String line = null;

		try {
			reader = new BufferedReader(new FileReader("symptoms.txt"));
			line = reader.readLine();

			while (line != null) {
				System.out.println("symptom from file: " + line);

				if (line.equals("headache")) {
					headacheCount++;
					System.out.println("number of headaches: " + headacheCount);
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
		FileWriter writer = null;

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
