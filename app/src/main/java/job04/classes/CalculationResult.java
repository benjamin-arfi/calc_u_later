package job04.classes;

public class CalculationResult {
    private double operand1;
    private static double operand2;
    private String signOperator;
    private double result;
    
    public CalculationResult(double operand1, double operand2,double result, String signOperator) {
        this.operand1 = operand1;
        CalculationResult.operand2 = operand2;
        this.signOperator = signOperator;
        this.result = result;
    }
    
    // Getters pour les valeurs encapsulées
    public double getOperand1() {
        return operand1;
    }
    
    public static double  getOperand2() {
        return operand2;
    }
    
    public String getSignOperator() {
        return signOperator;
    }

    public double getresult(){
        return result;
    }

    
}
