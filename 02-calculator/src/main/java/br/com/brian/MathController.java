package br.com.brian;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MathController {

    @RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double sum(@PathVariable(value = "numberOne") String numberOne, @PathVariable(value = "numberTwo") String numberTwo) throws Exception {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedOperationException("Please set a numeric value!");
        }

        Double sum = convertToDouble(numberOne) + convertToDouble(numberTwo);
        return sum;
    }

    @RequestMapping(value = "/subtraction/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double subtraction(@PathVariable(value = "numberOne") String numberOne, @PathVariable(value = "numberTwo") String numberTwo) throws Exception {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedOperationException("Please set a numeric value!");
        }

        Double division = convertToDouble(numberOne) - convertToDouble(numberTwo);
        return division;
    }

    @RequestMapping(value = "/multiplication/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double multiplication(@PathVariable(value = "numberOne") String numberOne, @PathVariable(value = "numberTwo") String numberTwo) throws Exception {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedOperationException("Please set a numeric value!");
        }

        if (convertToDouble(numberTwo) == 0) {
            throw new UnsupportedOperationException("The dividend must be greater than zero!");
        }

        Double division = convertToDouble(numberOne) * convertToDouble(numberTwo);
        return division;
    }

    @RequestMapping(value = "/division/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double division(@PathVariable(value = "numberOne") String numberOne, @PathVariable(value = "numberTwo") String numberTwo) throws Exception {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedOperationException("Please set a numeric value!");
        }

        if (convertToDouble(numberTwo) == 0) {
            throw new UnsupportedOperationException("The dividend must be greater than zero!");
        }

        Double division = convertToDouble(numberOne) / convertToDouble(numberTwo);
        return division;
    }

    @RequestMapping(value = "/average/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double average(@PathVariable(value = "numberOne") String numberOne, @PathVariable(value = "numberTwo") String numberTwo) throws Exception {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedOperationException("Please set a numeric value!");
        }

        Double division = (convertToDouble(numberOne) + convertToDouble(numberTwo)) / 2;
        return division;
    }

    @RequestMapping(value = "/square/{numberOne}", method = RequestMethod.GET)
    public Double square(@PathVariable(value = "numberOne") String numberOne) throws Exception {
        if (!isNumeric(numberOne)) {
            throw new UnsupportedOperationException("Please set a numeric value!");
        }

        Double division = Math.sqrt(convertToDouble(numberOne));
        return division;
    }

    private Double convertToDouble(String strNumber) {
        if (strNumber == null) return 0D;
        String number = strNumber.replaceAll(",", ".");
        if (isNumeric(number)) return Double.parseDouble(strNumber);
        return 0D;
    }

    private boolean isNumeric(String strNumber) {
        if (strNumber == null) return false;
        String number = strNumber.replaceAll(",", ".");
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }
}