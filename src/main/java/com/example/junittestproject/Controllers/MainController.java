package com.example.junittestproject.Controllers;

import com.example.junittestproject.Models.Operation;
import com.example.junittestproject.Services.ComputingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MainController {
    private final ComputingService computingService;

    @Autowired
    public MainController(ComputingService computingService) {
        this.computingService = computingService;
    }

    @GetMapping("/addition")
    public ResponseEntity<Operation> getResultAddition(@RequestBody Operation operation){
        return ResponseEntity.ok(computingService.operationReproduction(operation, "addition"));
    }

    @GetMapping("/subtraction")
    public ResponseEntity<Operation> getResultSubtraction(@RequestBody Operation operation){
        return ResponseEntity.ok(computingService.operationReproduction(operation, "subtraction"));
    }

    @GetMapping("/multiplication")
    public ResponseEntity<Operation> getResultMultiplication(@RequestBody Operation operation){
        return ResponseEntity.ok(computingService.operationReproduction(operation, "multiplication"));
    }

    @GetMapping("/division")
    public ResponseEntity<Operation> getResultDivision(@RequestBody Operation operation){
        return ResponseEntity.ok(computingService.operationReproduction(operation, "division"));
    }

}
