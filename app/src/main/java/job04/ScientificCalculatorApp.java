package job04;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import job04.classes.MainController;



public class ScientificCalculatorApp  {
    
    public static void BasicDisplay(GridPane gridPane,TextField displayField) {

        gridPane.getChildren().removeIf( node -> GridPane.getColumnIndex(node) == 4 && GridPane.getRowIndex(node) == 3);
        gridPane.getChildren().removeIf( node -> GridPane.getColumnIndex(node) == 4 && GridPane.getRowIndex(node) == 2);
        gridPane.getChildren().removeIf( node -> GridPane.getColumnIndex(node) == 4 && GridPane.getRowIndex(node) == 1);
        gridPane.getChildren().removeIf( node -> GridPane.getColumnIndex(node) == 4 && GridPane.getRowIndex(node) == 4);
        gridPane.getChildren().removeIf( node -> GridPane.getColumnIndex(node) == 4 && GridPane.getRowIndex(node) == 5);
        gridPane.getChildren().removeIf( node -> GridPane.getColumnIndex(node) == 5 && GridPane.getRowIndex(node) == 1);
        gridPane.getChildren().removeIf( node -> GridPane.getColumnIndex(node) == 5 && GridPane.getRowIndex(node) == 2);
    
    }
    public void ScientificDisplay(GridPane gridPane,TextField displayField) {

        gridPane.getChildren().removeIf( node -> GridPane.getColumnIndex(node) == 4 && GridPane.getRowIndex(node) == 3);
        gridPane.getChildren().removeIf( node -> GridPane.getColumnIndex(node) == 4 && GridPane.getRowIndex(node) == 2);
        gridPane.getChildren().removeIf( node -> GridPane.getColumnIndex(node) == 4 && GridPane.getRowIndex(node) == 1);
        // Création des boutons pour la calculatrice scientifique
        Button sinButton = createButton("sin");
        Button cosButton = createButton("cos");
        Button tanButton = createButton("tan");
        Button lnButton = createButton("ln");
        Button logButton = createButton("log");
        Button sqrtButton = createButton("√");
        Button powButton = createButton("x^2");
    

        // Gestion des événements des nouveaux boutons
        sinButton.setOnAction(e ->MainController.calculateOperatorUnaryClick("sin",displayField));
        cosButton.setOnAction(e -> MainController.calculateOperatorUnaryClick("cos",displayField));
        tanButton.setOnAction(e -> MainController.calculateOperatorUnaryClick("tan",displayField));
        lnButton.setOnAction(e -> MainController.calculateOperatorUnaryClick("ln",displayField));
        logButton.setOnAction(e -> MainController.calculateOperatorUnaryClick("log",displayField));
        sqrtButton.setOnAction(e -> MainController.calculateOperatorUnaryClick("√",displayField));
        powButton.setOnAction(e -> MainController.handleOperatorClick("x^",displayField));

        gridPane.add(sinButton, 4, 1);
        gridPane.add(cosButton, 4, 2);
        gridPane.add(tanButton, 4, 3);
        gridPane.add(lnButton, 4, 4);
        gridPane.add(logButton, 4, 5);
        gridPane.add(sqrtButton, 5, 1);
        gridPane.add(powButton, 5, 2);
    }
    

    // Méthode utilitaire pour créer les boutons de fonction
    private Button createButton(String text) {
        Button button = new Button(text);
        button.setPrefSize(70, 30);
        return button;
    }
}