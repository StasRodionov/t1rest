package com.example.stasrod.t1rest.controller;

import com.example.stasrod.t1rest.exception.CustomerElementException;
import com.example.stasrod.t1rest.service.FrequencyService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.*;


@RestController
@RequestMapping("/api/frequency/")
@AllArgsConstructor
@OpenAPIDefinition(info = @Info(title = "Frequency of Occurrence of Symbols", description = "Symbol Frequency Information"))
@Tag(name = "FrequencyController", description = "Operations related to frequency calculation")
public class FrequencyController {

    private final FrequencyService frequencyService;

    @Operation(summary = "Calculate frequency of characters")
    @PostMapping
    public ResponseEntity<Map<Character, Integer>> countFrequency (@RequestBody(required = false) String string){
        if (string == null) {
            throw new CustomerElementException("Не может быть пустой строкой");
        }
        Map<Character, Integer> mapFrequency = frequencyService.countFrequency(string);
        return new ResponseEntity<>(mapFrequency, HttpStatus.OK);
    }
    @ExceptionHandler(CustomerElementException.class)
    public ResponseEntity<String> handleException(CustomerElementException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
}

