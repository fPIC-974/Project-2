package com.hemebiotech.analytics;

import java.io.*;
import java.util.*;


/**
 * Implementation to write data to a file
 *
 */
public class WriteSymptomDataToFile implements ISymptomWriter {

	final String filepath;

	/**
	 *
	 * @param filepath a full or partial path to file with symptom strings in it, one per line
	 */
	public WriteSymptomDataToFile(String filepath) {
		this.filepath = filepath;
	}

	/**
	 * Write a list of sorted symptoms (Treemap) to file
	 *
	 * @param inList an ordered list of symptoms
	 */
	@Override
	public void putSymptoms(TreeMap<String, Integer> inList) {
		FileWriter writer = null;

		if (filepath != null) {
			try {
				writer = new FileWriter(this.filepath);

				for (Map.Entry<String, Integer> symptom : inList.entrySet()) {
					String key = symptom.getKey();
					Integer value = symptom.getValue();
					writer.write(key + ": " + value + "\n");
				}
			} catch (FileNotFoundException e) {
				System.out.println("File not found : " + filepath);
				e.printStackTrace();
			} catch (IOException e) {
				System.out.println("Unknown error while writing results to :" + this.filepath);
				e.printStackTrace();
			} finally {
				if (writer != null) {
					try {
						writer.close();
					} catch (IOException e) {
						System.out.println("Unable to close file : " + this.filepath);
						e.printStackTrace();
					}
				}
			}
		}
	}
}
