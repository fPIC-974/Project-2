package com.hemebiotech.analytics;

import java.util.TreeMap;

/**
 * Anything that will write symptom data to a destination
 *
 * Data provided as TreeMap for sorting purpose
 * 
 */
public interface ISymptomWriter {
	/**
	 *
	 * @param data an ordered list of symptoms
	 */
	void putSymptoms (TreeMap<String, Integer> data);
}
