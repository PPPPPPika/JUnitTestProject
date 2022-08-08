package com.example.junittestproject.Models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "result_table")
public class Operation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "operation")
    private String nameOperation;

    @Column(name = "result")
    private int result;

    @Column(name = "number1")
    private int number1;

    @Column(name = "number2")
    private int number2;

    public Operation(Long id, String nameOperation, int result, int number1, int number2) {
        this.id = id;
        this.nameOperation = nameOperation;
        this.result = result;
        this.number1 = number1;
        this.number2 = number2;
    }

    public Operation() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameOperation() {
        return nameOperation;
    }

    public void setNameOperation(String nameOperation) {
        this.nameOperation = nameOperation;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public int getNumber1() {
        return number1;
    }

    public void setNumber1(int number1) {
        this.number1 = number1;
    }

    public int getNumber2() {
        return number2;
    }

    public void setNumber2(int number2) {
        this.number2 = number2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Operation operation = (Operation) o;
        return result == operation.result && number1 == operation.number1
                && number2 == operation.number2
                && Objects.equals(nameOperation, operation.nameOperation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameOperation, result, number1, number2);
    }

    @Override
    public String toString() {
        return "Operation{" +
                "id=" + id +
                ", nameOperation='" + nameOperation + '\'' +
                ", result=" + result +
                ", number1=" + number1 +
                ", number2=" + number2 +
                '}';
    }
}
