package com.hemebiotech.analytics;

import java.util.*;

public class Symptoms {
    private List<String> rawList;

    /**
     *
     * @param inList a raw list of symptoms extracted from input stream
     */
    public Symptoms(List<String> inList) { this.rawList = inList; }


    /**
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
     *
     * @return a sorted map of unique symptoms and their number
     */
    public TreeMap<String, Integer> getSortedSymptoms() {

        TreeMap<String, Integer> sortedSymptoms = new TreeMap<>(this.getUniqueSymptoms());

        return sortedSymptoms;
    }

}
