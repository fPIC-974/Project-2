package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementation to read data from a file
 *
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

	final String filepath;
	
	/**
	 * 
	 * @param filepath a full or partial path to file with symptom strings in it, one per line
	 */
	public ReadSymptomDataFromFile (String filepath) {
		this.filepath = filepath;
	}

	/**
	 * Read raw symptom data from file
	 *
	 * @return a raw list of symptoms
	 */
	@Override
	public List<String> getSymptoms() {
		ArrayList<String> result = new ArrayList<>();
		BufferedReader reader = null;
		
		if (filepath != null) {
			try {
				reader = new BufferedReader (new FileReader(filepath));
				String line = reader.readLine();
				
				while (line != null) {
					result.add(line);
					line = reader.readLine();
				}
			} catch (FileNotFoundException e) {
				System.out.println("File not fount : " + filepath);
			} catch (IOException e) {
				System.out.println("Unknown error while reading file : " + filepath);
				e.printStackTrace();
			} finally {
				if (reader != null) {
					try {
						reader.close();
					} catch (IOException e) {
						System.out.println("Unable to close file : " + filepath);
						e.printStackTrace();
					}
				}
			}
		}
		
		return result;
	}

}
