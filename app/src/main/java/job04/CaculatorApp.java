package job04;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import job04.classes.DisplayNumber;

public class CaculatorApp extends Application {

    private TextField displayField;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Calculatrice");

        // Création du champ d'affichage
        displayField = new TextField();
        displayField.setEditable(false);
        displayField.setAlignment(Pos.CENTER_RIGHT);

        // Création des boutons numériques et opérationnels
        Button button1 = createButton("1");
        button1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DisplayNumber.displayNumber(button1.getText(),displayField);
            }
        });
        Button button2 = createButton("2");
        button2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DisplayNumber.displayNumber(button2.getText(),displayField);
            }
        });
        Button button3 = createButton("3");
        button3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DisplayNumber.displayNumber(button3.getText(),displayField);
            }
        });
        Button button4 = createButton("4");
        button4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DisplayNumber.displayNumber(button4.getText(),displayField);
            }
        });
        Button button5 = createButton("5");
        button5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DisplayNumber.displayNumber(button5.getText(),displayField);
            }
        });
        Button button6 = createButton("6");
        button6.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DisplayNumber.displayNumber(button6.getText(),displayField);
            }
        });
        Button button7 = createButton("7");
        button7.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DisplayNumber.displayNumber(button7.getText(),displayField);
            }
        });
        Button button8 = createButton("8");
        button8.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DisplayNumber.displayNumber(button8.getText(),displayField);
            }
        });
        Button button9 = createButton("9");
        button9.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DisplayNumber.displayNumber(button9.getText(),displayField);
            }
        });
        Button button0 = createButton("0");
        button0.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DisplayNumber.displayNumber(button0.getText(),displayField);
            }
        });
        Button buttonAdd = createButton("+");
        Button buttonSubtract = createButton("-");
        Button buttonMultiply = createButton("*");
        Button buttonDivide = createButton("/");
        Button buttonEquals = createButton("=");
        Button buttonPercentage = createButton("%");

        // Configuration de la disposition en grille
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(10));

        // Ajout des boutons à la grille
        gridPane.add(displayField, 0, 0, 4, 1);
        gridPane.add(button1, 0, 1);
        gridPane.add(button2, 1, 1);
        gridPane.add(button3, 2, 1);
        gridPane.add(buttonAdd, 3, 1);
        gridPane.add(button4, 0, 2);
        gridPane.add(button5, 1, 2);
        gridPane.add(button6, 2, 2);
        gridPane.add(buttonSubtract, 3, 2);
        gridPane.add(button7, 0, 3);
        gridPane.add(button8, 1, 3);
        gridPane.add(button9, 2, 3);
        gridPane.add(buttonMultiply, 3, 3);
        gridPane.add(button0, 0, 4);
        gridPane.add(buttonEquals, 1, 4);
        gridPane.add(buttonPercentage, 2, 4);
        gridPane.add(buttonDivide, 3, 4);

        // Création de la scène
        Scene scene = new Scene(gridPane, 300, 250);

        // Appliquer la scène à la fenêtre principale
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Méthode utilitaire pour créer un bouton avec un texte spécifique
    private Button createButton(String text) {
        Button button = new Button(text);
        button.setPrefSize(70, 30);
        return button;
    }

    public static void main(String[] args) {
        launch();
    }
}
