package com.hemebiotech.analytics;

import java.util.*;

/**
 * Operations on a raw list of symptoms
 *
 */
public class Symptoms {
    final List<String> rawList;

    /**
     *
     * @param inList a raw list of symptoms extracted from input stream
     */
    public Symptoms(List<String> inList) { this.rawList = inList; }


    /**
     * Get a list of unique symptoms from raw data
     *
     * @return a map of unique symptoms and their number
     */
    public Map<String, Integer> getUniqueSymptoms() {
        Map<String, Integer> uniqueSymptoms = new HashMap<>();

        for (String symptom:rawList) {
            if (uniqueSymptoms.containsKey(symptom)) {
                uniqueSymptoms.replace(symptom, uniqueSymptoms.get(symptom) + 1);
            } else {
                uniqueSymptoms.put(symptom, 1);
            }
        }
        return uniqueSymptoms;
    }


    /**
     * Get a sorted list of unique symptoms from raw data
     *
     * @return a sorted map of unique symptoms and their number
     */
    public TreeMap<String, Integer> getSortedSymptoms() {
        return (new TreeMap<>(this.getUniqueSymptoms()));
    }

}
