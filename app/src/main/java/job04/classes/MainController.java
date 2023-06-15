package job04.classes;
import javafx.scene.control.TextField;

public class MainController {
    private static double operand1;
    private static String signoperator;
    private static double operand2;
    private static double operand;
    private static double result;

    public static void handleOperatorClick(String operator, TextField displayField) {
        operand1 = Double.parseDouble(displayField.getText());
        signoperator = operator;
        displayField.clear();
    }

    public static void ResetActualNumber(TextField displayField) {
        displayField.clear();
    }

    // Method to perform the calculation and display the result
    public static CalculationResult calculateResult(TextField displayField) {
        operand2 = Double.parseDouble(displayField.getText());
        result = 0;

        if (signoperator.equals("+")) {
            result = operand1 + operand2;
        } else if (signoperator.equals("-")) {
            result = operand1 - operand2;
        } else if (signoperator.equals("*")) {
            result = operand1 * operand2;
        } else if (signoperator.equals("/")) {
            result = operand1 / operand2;
        } else if (signoperator.equals("rebate %")) {
            result = operand1 * (1.0 - (operand2 / 100.0));
        } else if (signoperator.equals("increase %")) {
            result = operand1 * (1.0 + (operand2 / 100.0));
        } else if (signoperator.equals("part of")) {
            result = operand1 * (operand2 / 100.0);
        } else if (signoperator.equals("x^")) {
            result = Math.pow(operand1, operand2);
        }

        displayField.setText(String.valueOf(result));
        return new CalculationResult(operand1, operand2, result, signoperator);
    }

    public static CalculationResultUnary calculateOperatorUnaryClick(String operator, TextField displayField) {
        operand1 = Double.parseDouble(displayField.getText());
        double result = 0;
        signoperator = operator;
        if (signoperator.equals("sin")) {
            operand = Math.toRadians(operand1);
            result = (Math.sin(operand));
        } else if (signoperator.equals("cos")) {
            operand = Math.toRadians(operand1);
            result = Math.cos(operand);
        } else if (signoperator.equals("tan")) {
            operand = Math.toRadians(operand1);
            result = Math.tan(operand);
        } else if (signoperator.equals("ln")) {
            result = Math.log(operand1);
        } else if (signoperator.equals("log")) {
            result = Math.log10(operand1);
        } else if (signoperator.equals("√")) {
            result = Math.sqrt(operand1);
        } else if (signoperator.equals("x^")) {
            result = Math.pow(operand1, operand2);
        }

        displayField.setText(String.valueOf(result));
        return new CalculationResultUnary(operand1, result, signoperator);
    }

    public static void ResetAllClear(TextField displayField) {
        operand1 = 0;
        operand2 = 0;
        displayField.clear();
    }
}