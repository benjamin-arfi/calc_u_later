package job04.classes;

import javafx.scene.control.TextField;
import java.util.HashMap;
import java.util.Map;

public class MainController {
    private static double operand1;
    private static String signoperator;
    private static double operand2;
    private static double operand;
    private static double result;
    private static Map<String, Double> variables = new HashMap<>();

    public static void handleOperatorClick(String operator, TextField displayField) {
        operand1 = Double.parseDouble(displayField.getText());
        signoperator = operator;
        displayField.clear();
    }

    public static void ResetActualNumber(TextField displayField) {
        displayField.clear();
    }

    // Méthode pour effectuer le calcul et afficher le résultat
    public static CalculationResult calculateResult(TextField displayField) {
        operand2 = getOperandValue(displayField.getText());
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

    private static double getOperandValue(String operand) {
        double value = 0.0;
        if (operand.startsWith("$")) {
            String variableName = operand.substring(1); // Ignorer le préfixe "$"
            if (variables.containsKey(variableName)) {
                value = variables.get(variableName);
            } else {
                // Gérer le cas où la variable n'existe pas ici
            }
        } else {
            try {
                value = Double.parseDouble(operand);
            } catch (NumberFormatException ex) {
                // Gérer une erreur de format de valeur ici
            }
        }
        return value;
    }
}
