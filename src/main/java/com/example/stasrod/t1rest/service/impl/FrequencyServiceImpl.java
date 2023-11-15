package com.example.stasrod.t1rest.service.impl;

import com.example.stasrod.t1rest.service.FrequencyService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class FrequencyServiceImpl implements FrequencyService {
    @Override
    public Map<Character, Integer> countFrequency(String string) {

        Map<Character, Integer> mapFrequency = new HashMap<>();
        for (char c : string.toCharArray()) {
            mapFrequency.put(c, mapFrequency.getOrDefault(c, 0) + 1);
        }

        List<Map.Entry<Character, Integer>> list = new ArrayList<>(mapFrequency.entrySet());

        list.sort(Map.Entry.comparingByValue());
        Collections.reverse(list);

        LinkedHashMap<Character, Integer> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<Character, Integer> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        return sortedMap;
    }
}
