package job04;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import job04.classes.MainController;

public class ScientificCalculatorApp  {
    
    public void ScientificDisplay(GridPane gridPane,TextField displayField,List<String> historiqueCalculs,ListView<String> historiqueListView,List<String> variableNames,ListView<String> varListView) {

        gridPane.getChildren().removeIf( node -> GridPane.getColumnIndex(node) == 4 && GridPane.getRowIndex(node) == 3);
        gridPane.getChildren().removeIf( node -> GridPane.getColumnIndex(node) == 4 && GridPane.getRowIndex(node) == 2);
        gridPane.getChildren().removeIf( node -> GridPane.getColumnIndex(node) == 4 && GridPane.getRowIndex(node) == 1);
        gridPane.getChildren().removeIf( node -> GridPane.getColumnIndex(node) == 5 && GridPane.getRowIndex(node) == 0);
        gridPane.getChildren().removeIf( node -> GridPane.getColumnIndex(node) == 6 && GridPane.getRowIndex(node) == 0);

        Button sinButton = createButton("sin");
        Button cosButton = createButton("cos");
        Button tanButton = createButton("tan");
        Button lnButton = createButton("ln");
        Button logButton = createButton("log");
        Button sqrtButton = createButton("√");
        Button powButton = createButton("x^2");

        sinButton.setOnAction(e ->{
        job04.classes.CalculationResultUnary prin = MainController.calculateOperatorUnaryClick("sin",displayField);
        double operand1 = prin.getOperand1U();
        String signOperator = prin.getSignOperatorU();
        double result = prin.getresultU();

        String calcul = operand1 + signOperator + " = " + result;
        historiqueCalculs.add(calcul);

        historiqueListView.setItems(FXCollections.observableArrayList(historiqueCalculs));});
        cosButton.setOnAction(e -> {
        job04.classes.CalculationResultUnary prin = MainController.calculateOperatorUnaryClick("cos",displayField);
        double operand1 = prin.getOperand1U();
        String signOperator = prin.getSignOperatorU();
        double result = prin.getresultU();
        String calcul = operand1 + signOperator + " = " + result;
        historiqueCalculs.add(calcul);
     
        historiqueListView.setItems(FXCollections.observableArrayList(historiqueCalculs));});

        tanButton.setOnAction(e -> {
        job04.classes.CalculationResultUnary prin = MainController.calculateOperatorUnaryClick("tan",displayField);
        double operand1 = prin.getOperand1U();
        String signOperator = prin.getSignOperatorU();
        double result = prin.getresultU();
        String calcul = operand1 + signOperator + " = " + result;
        historiqueCalculs.add(calcul);
        
        historiqueListView.setItems(FXCollections.observableArrayList(historiqueCalculs));});

        lnButton.setOnAction(e -> {
        job04.classes.CalculationResultUnary prin = MainController.calculateOperatorUnaryClick("ln",displayField);
        double operand1 = prin.getOperand1U();
        String signOperator = prin.getSignOperatorU();
        double result = prin.getresultU();
        String calcul = operand1 + signOperator + " = " + result;
        historiqueCalculs.add(calcul);
        
        historiqueListView.setItems(FXCollections.observableArrayList(historiqueCalculs));});

        logButton.setOnAction(e -> {
        job04.classes.CalculationResultUnary prin = MainController.calculateOperatorUnaryClick("log",displayField);
        double operand1 = prin.getOperand1U();
        String signOperator = prin.getSignOperatorU();
        double result = prin.getresultU();
        String calcul = operand1 + signOperator + " = " + result;
        historiqueCalculs.add(calcul);
        
        historiqueListView.setItems(FXCollections.observableArrayList(historiqueCalculs));});

        sqrtButton.setOnAction(e -> {
        job04.classes.CalculationResultUnary prin = MainController.calculateOperatorUnaryClick("√",displayField);
        double operand1 = prin.getOperand1U();
        String signOperator = prin.getSignOperatorU();
        double result = prin.getresultU();
        String calcul = operand1 + signOperator + " = " + result;
        historiqueCalculs.add(calcul);
        
        historiqueListView.setItems(FXCollections.observableArrayList(historiqueCalculs));});

        powButton.setOnAction(e -> MainController.handleOperatorClick("x^",displayField));

        gridPane.add(sinButton, 4, 1);
        gridPane.add(cosButton, 4, 2);
        gridPane.add(tanButton, 4, 3);
        gridPane.add(lnButton, 4, 4);
        gridPane.add(logButton, 4, 5);
        gridPane.add(sqrtButton, 5, 1);
        gridPane.add(powButton, 5, 2);        
        gridPane.add(historiqueListView, 6, 0, 1, 7);
        gridPane.add(varListView, 7, 0, 1, 7);   
    }

    private Button createButton(String text) {
        Button button = new Button(text);
        button.setPrefSize(100, 30);
        return button;
    }
}