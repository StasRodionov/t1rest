package com.example.stasrod.t1rest.controller;

import com.example.stasrod.t1rest.service.FrequencyService;
import com.example.stasrod.t1rest.service.impl.FrequencyServiceImpl;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class FrequencyControllerTest {
    private static final FrequencyService frequencyService = new FrequencyServiceImpl();

    @Test
    void countFrequency1() {
        Map<Character, Integer> charMap = frequencyService.countFrequency("aaaaabcccc");

        assertEquals(charMap.get('a'), 5);
        assertEquals(charMap.get('b'), 1);
        assertEquals(charMap.get('c'), 4);

        assertNull(charMap.get(' '));
    }

    @Test
    public void test4() {
        Map<Character, Integer> charMap = frequencyService.countFrequency("");

        assertTrue(charMap.isEmpty());
    }
}