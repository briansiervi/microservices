package br.com.brian.math;

import br.com.brian.converters.NumberConverter;

public class Operation {
    private String numberOne;
    private String numberTwo;

    public Operation(String numberOne, String numberTwo) {
        this.numberOne = numberOne;
        this.numberTwo = numberTwo;

        if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
            throw new UnsupportedOperationException("Please set a numeric value!");
        }
    }

    public Operation(String numberOne) {
        this.numberOne = numberOne;

        if (!NumberConverter.isNumeric(numberOne)) {
            throw new UnsupportedOperationException("Please set a numeric value!");
        }
    }

    public Double sum() {
        return NumberConverter.convertToDouble(numberOne) + NumberConverter.convertToDouble(numberTwo);
    }

    public Double subtraction() {
        return NumberConverter.convertToDouble(numberOne) - NumberConverter.convertToDouble(numberTwo);
    }

    public Double multiplication() {
        return NumberConverter.convertToDouble(numberOne) * NumberConverter.convertToDouble(numberTwo);
    }

    public Double division() {
        if (NumberConverter.convertToDouble(numberTwo) == 0) {
            throw new UnsupportedOperationException("The dividend must be greater than zero!");
        }

        return NumberConverter.convertToDouble(numberOne) / NumberConverter.convertToDouble(numberTwo);
    }

    public Double average() {
        return (NumberConverter.convertToDouble(numberOne) + NumberConverter.convertToDouble(numberTwo)) / 2;
    }

    public Double square() {
        return Math.sqrt(NumberConverter.convertToDouble(numberOne));
    }
}
