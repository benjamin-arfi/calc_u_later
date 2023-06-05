package job04;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

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
        Button button2 = createButton("2");
        Button button3 = createButton("3");
        Button button4 = createButton("4");
        Button button5 = createButton("5");
        Button button6 = createButton("6");
        Button button7 = createButton("7");
        Button button8 = createButton("8");
        Button button9 = createButton("9");
        Button button0 = createButton("0");
        Button buttonAdd = createButton("+");
        Button buttonSubtract = createButton("-");
        Button buttonMultiply = createButton("*");
        Button buttonDivide = createButton("/");
        Button buttonEquals = createButton("=");

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
        gridPane.add(buttonEquals, 1, 4, 2, 1);
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
