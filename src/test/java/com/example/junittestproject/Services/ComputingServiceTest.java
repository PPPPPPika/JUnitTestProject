package com.example.junittestproject.Services;

import com.example.junittestproject.Models.Operation;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ComputingServiceTest {
    private final ComputingService computingService;

    @Autowired
    public ComputingServiceTest(ComputingService computingService) {
        this.computingService = computingService;
    }

    /*@BeforeAll
    static void someData(){
        System.out.println("Start test-process");
    }

    @AfterAll
    static void someData1(){
        System.out.println("Finish test-process");
    }*/

    @BeforeEach
    void someData2(){
        System.out.println("Test is run");
    }

    @AfterEach
    void someData3(){
        System.out.println("Test is finish");
    }

    //@Disabled
    //@Tag("addition")

    //@ParameterizedTest
    //подстановка значений
    //@NullAndEmptySource
    //@EmptySource
    //@NullSource

    //@ParameterizedTest(name = )
    //@ValueSource(arguments = {})//только с примитивами

    /*@Test
    void operationReproduction() {
        Operation operationTest = new Operation(null, null, 0, 2, 3);
        String stringTest = "addition";
        Operation operationTestResult = new Operation(null, "addition", 5, 2, 3);;

        Operation currentOperation = computingService.operationReproduction(operationTest, stringTest);

        assertEquals(currentOperation, operationTestResult);
    }*/

    @DisplayName("private method")
    //@RepeatedTest(3)
    @Test
    void testPrivateComputingOperation() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = ComputingService.class.getDeclaredMethod("computingOperation", Operation.class, String.class);

        Operation operationTest = new Operation(null, null, 0, 2, 3);
        String stringTest = "addition";
        Operation operationTestResult = new Operation(null, null, 5, 2, 3);;

        method.setAccessible(true);

        assertEquals(method.invoke(computingService, operationTest, stringTest), operationTestResult);
    }


    //////////////////////////////////////////////////////////////////////////////////////


    /*@ParameterizedTest
      @CsvSource(value = {})*/
    //аннотация позволяет задавать списки аргументов как значения, разделенные запятыми.
    @ParameterizedTest(name = "{index} - {0} is right!")
    @ArgumentsSource(ArgumentsProvider.class)
    void operationReproduction(Operation operation, String nameOperation) {
        Operation operationTest = operation;
        String stringTest = nameOperation;

        Operation operationTestResult = new Operation(null, "addition", 5, 2, 3);

        Operation currentOperation = computingService.operationReproduction(operationTest, stringTest);

        assertEquals(currentOperation, operationTestResult);
    }

    static class ArgumentsProvider implements org.junit.jupiter.params.provider.ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new Operation(null, null, 0, 2, 3), "addition"),
                    Arguments.of(new Operation(null, null, 0, 1, 1), "addition"),
                    Arguments.of(new Operation(null, null, 0, 1, 9), "addition")
            );
        }
    }



}