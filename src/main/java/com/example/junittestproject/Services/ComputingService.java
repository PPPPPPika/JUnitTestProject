package com.example.junittestproject.Services;

import com.example.junittestproject.Models.Operation;
import com.example.junittestproject.Reposytorys.OperationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComputingService {
    private final OperationRepository operationRepository;

    @Autowired
    public ComputingService(OperationRepository operationRepository) {
        this.operationRepository = operationRepository;
    }

    private Operation computingOperation(Operation operation, String nameOperation){
        int result = switch (nameOperation) {
            case "addition" -> operation.getNumber1() + operation.getNumber2();
            case "subtraction" -> operation.getNumber1() - operation.getNumber2();
            case "multiplication" -> operation.getNumber1() * operation.getNumber2();
            case "division" -> operation.getNumber1() / operation.getNumber2();
            default -> 0;
        };
        operation.setResult(result);
        return operation;
    }

    public Operation operationReproduction(Operation operation, String nameOperation) {
        operation.setNameOperation(nameOperation);
        Operation resultOperation = computingOperation(operation, nameOperation);
        return operationRepository.save(resultOperation);
    }

}
