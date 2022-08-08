package com.example.junittestproject.Controllers;

import com.example.junittestproject.Models.Operation;
import com.example.junittestproject.Services.ComputingService;
import org.junit.Ignore;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

//@WebMvcTest(MainController.class)
//@RunWith(SpringRunner.class)
//ContextConfiguration(locations={"/api/addition"})
@SpringBootTest
class MainControllerTest {

    @Autowired
    private ComputingService computingService;

    @ParameterizedTest
    @ArgumentsSource(ArgumentsProvider.class)
    void getResultAddition(Operation operation) {
        System.out.println("Operation: " + operation);

        String nameOperation = "addition";

        Operation outputAllegedOperation = computingService.operationReproduction(operation, nameOperation);

        assertEquals(operation, outputAllegedOperation);
    }

    static class ArgumentsProvider implements org.junit.jupiter.params.provider.ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new Operation(null, null, 0, 2, 3)),
                    Arguments.of(new Operation(null, null, 0, 1, 1)),
                    Arguments.of(new Operation(null, null, 0, 1, 9))
            );
        }
    }

    @Disabled
    @Test
    void getResultSubtraction() {
    }

    @Disabled
    @Test
    void getResultMultiplication() {
    }

    @Disabled
    @Test
    void getResultDivision() {
    }
}