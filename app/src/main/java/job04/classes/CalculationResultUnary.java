package job04.classes;

public class CalculationResultUnary {
        private double operand1;
        private String signOperator;
        private double result;


    public CalculationResultUnary (double operand1,double result, String signOperator) {
        this.operand1 = operand1;
        this.signOperator = signOperator;
        this.result = result;
    }
    
    // Getters pour les valeurs encapsulées
    public double getOperand1U() {
        return operand1;
    }
    
    public String getSignOperatorU() {
        return signOperator;
    }

    public double getresultU(){
        return result;
    }
}
