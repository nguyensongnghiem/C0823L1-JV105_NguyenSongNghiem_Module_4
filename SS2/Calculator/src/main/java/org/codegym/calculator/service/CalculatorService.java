package org.codegym.calculator.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {
    public Float add(float a, float b) {
        return a+b;
    }
    public Float sub(float a, float b) {
        return a-b;
    }
    public Float mul(float a, float b) {
        return a*b;
    }
    public Float div(float a, float b) {
        try {
        return a/b;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
