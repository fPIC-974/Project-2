package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadSymptomDataFromFile implements ISymptomReader {

	private String filepath;
	
	/**
	 * 
	 * @param filepath a full or partial path to file with symptom strings in it, one per line
	 */
	public ReadSymptomDataFromFile (String filepath) {
		this.filepath = filepath;
	}
	
	@Override
	public List<String> getSymptoms() {
		ArrayList<String> result = new ArrayList<String>();
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
				// sout
				e.printStackTrace();
			} finally {
				try {
					reader.close();
				} catch (IOException e) {
					// sout
					e.printStackTrace();
				}
			}
		}
		
		return result;
	}

}
