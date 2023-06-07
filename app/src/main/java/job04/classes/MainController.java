package job04.classes;

import javafx.scene.control.TextField;

public class MainController {
    private static double operand1;
    private static String signoperator;
    private static double operand2;

	public static void handleOperatorClick(String operator,TextField displayField) {
		operand1 = Double.parseDouble(displayField.getText());
		signoperator = operator;
		displayField.clear();
	}
	
	public static void ResetActualNumber(TextField displayField) {
		displayField.clear();
	}
	
	
	
	// Méthode pour effectuer le calcul et afficher le résultat
	public static void calculateResult(TextField displayField) {
		operand2 = Double.parseDouble(displayField.getText());
		double result = 0;
	
		if (signoperator.equals("+")) {
			result = operand1 + operand2;
		} else if (signoperator.equals("-")) {
			result = operand1 - operand2;
		} else if (signoperator.equals("*")){
			result = operand1 * operand2;
		} else if (signoperator.equals("/")){
			result = operand1 / operand2;
		} else if (signoperator.equals("rebate %")){
            result = operand1*(1.0-(operand2/100.0));
		} else if (signoperator.equals("increase %")){
            result= operand1*(1.0+(operand2/100.0));
		} else if (signoperator.equals("part of")){
            result = operand1*(operand2/100.0);
		}
	
	
		displayField.setText(String.valueOf(result));
	}
	
	public static void ResetAllClear(TextField displayField) {
		operand1 = 0;
		operand2 = 0;
		displayField.clear();
	}
}