package job04;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import job04.classes.ConversionDisplay;
import job04.classes.MainController;
import job04.classes.MemorySave;
public class CaculatorApp extends Application {

    private TextField displayField;
    private TextField memoryField;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Calculatrice");
        
        
        
        Menu convertMenu = new Menu("Convert");

        MenuItem menuItemMasses = new MenuItem("Masses");
        MenuItem menuItemLongueur = new MenuItem("Longueur");
        MenuItem menuItemTemperature = new MenuItem("Temperature");
        MenuItem menuItemVolumes = new MenuItem("Volumes");
        

        convertMenu.getItems().add(menuItemMasses);
        convertMenu.getItems().add(menuItemLongueur);
        convertMenu.getItems().add(menuItemTemperature);
        convertMenu.getItems().add(menuItemVolumes);

        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().add(convertMenu);

        VBox vBox = new VBox(menuBar);
        // Création du champ d'affichage
        displayField = new TextField();
        displayField.setEditable(false);
        displayField.setAlignment(Pos.CENTER_RIGHT);
        memoryField = new TextField();
        memoryField.setEditable(false);

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
        Button buttonEquals = createButton("=");
        Button buttonMultiply = createButton("*");
        Button buttonDivide = createButton("/");
        
        Button buttonC = createButton("C");
        Button buttonAC = createButton("AC");
        Button buttonRebate = createButton("rebate %");
        Button buttonIncrease = createButton("increase %");
        Button buttonPartOf = createButton("part of");
        Button buttonMemory = createButton("MS");
        Button buttonMemoryRead = createButton("MR");
        Button buttonMemoryClear = createButton("MC");

        // Configuration de la disposition en grille
        GridPane gridPane = new GridPane();
        gridPane.setMaxSize(400, 200);
        gridPane.setPadding(new Insets(10));
        gridPane.setLayoutY(20);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        

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
        gridPane.add(buttonC, 2, 4);
        gridPane.add(buttonDivide, 3, 4);
        gridPane.add(buttonAC ,4,4 );
        gridPane.add(buttonRebate ,4,3, 2, 1 );
        gridPane.add(buttonIncrease ,4,2, 2, 1 );
        gridPane.add(buttonPartOf ,4,1, 2, 1 );
        gridPane.add(buttonMemory ,5,4 );
        gridPane.add(buttonMemoryRead ,4,5 );
        gridPane.add(buttonMemoryClear ,5,5 );
        gridPane.add(memoryField, 4, 0, 2, 1);


        // Gestion des événements des boutons
        

        button1.setOnAction(e -> appendToDisplay("1"));
        button2.setOnAction(e -> appendToDisplay("2"));
        button3.setOnAction(e -> appendToDisplay("3"));
        button4.setOnAction(e -> appendToDisplay("4"));
        button5.setOnAction(e -> appendToDisplay("5"));
        button6.setOnAction(e -> appendToDisplay("6"));
        button7.setOnAction(e -> appendToDisplay("7"));
        button8.setOnAction(e -> appendToDisplay("8"));
        button9.setOnAction(e -> appendToDisplay("9"));
        button0.setOnAction(e -> appendToDisplay("0"));

        buttonAdd.setOnAction(e -> MainController.handleOperatorClick("+",displayField));
        buttonSubtract.setOnAction(e -> MainController.handleOperatorClick("-",displayField));
        buttonEquals.setOnAction(e -> MainController.calculateResult(displayField));
        buttonMultiply.setOnAction(e -> MainController.handleOperatorClick("*",displayField));
        buttonDivide.setOnAction(e -> MainController.handleOperatorClick("/",displayField));
        buttonRebate.setOnAction(e -> MainController.handleOperatorClick("rebate %",displayField));
        buttonIncrease.setOnAction(e -> MainController.handleOperatorClick("increase %",displayField));
        buttonPartOf.setOnAction(e -> MainController.handleOperatorClick("part of",displayField));
        buttonMemory.setOnAction(e -> MemorySave.memorySave(displayField.getText(),memoryField,displayField));
        buttonMemoryRead.setOnAction(e -> MemorySave.memoryRead(displayField));
        buttonMemoryClear.setOnAction(e -> MemorySave.memoryClear(memoryField));
        buttonC.setOnAction(e -> MainController.ResetActualNumber(displayField));
        buttonAC.setOnAction(e -> MainController.ResetAllClear(displayField));

        // Création de la scène
        Group root = new Group(vBox,gridPane);
        Scene scene = new Scene(root);

        menuItemMasses.setOnAction(e -> {
            String masses[] ={ "Kilogrammes", "Grammes", "Livres","Onces" };
            ConversionDisplay.display(masses,gridPane,displayField,primaryStage);
        });
        menuItemLongueur.setOnAction(e -> {
            String longueurs[] ={ "Centimètres", "Pouces", "Mètres", "Pieds" };
            ConversionDisplay.display(longueurs,gridPane,displayField,primaryStage);
        });
        menuItemTemperature.setOnAction(e -> {
            String temperature[] ={ "Celsius", "Fahrenheit", "Kelvin" };
            ConversionDisplay.display(temperature,gridPane,displayField,primaryStage);
        });
        menuItemVolumes.setOnAction(e -> {
            String volumes[] ={ "Litres", "Gallons", "Mètres cubes", "Pieds cubes" };
            ConversionDisplay.display(volumes,gridPane,displayField,primaryStage);
        });
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

    // Méthode pour ajouter du texte au champ d'affichage
    private void appendToDisplay(String text) {
        displayField.setText(displayField.getText() + text);
    }

    

    public static void main(String[] args) {
        launch(args);
    }
}
