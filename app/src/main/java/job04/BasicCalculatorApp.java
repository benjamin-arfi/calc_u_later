package job04;

import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import job04.classes.CalculationResult;
import job04.classes.ConversionDisplay;
import job04.classes.MainController;
import job04.classes.CurrencyConverter;
import job04.classes.MemorySave;
public class BasicCalculatorApp extends Application {

    private TextField displayField;
    private TextField memoryField;
    
    private TextField variableNameField;
    private static List<String> variableNames = new ArrayList<>();
    private ListView<String> varListView = new ListView<>();

    private List<String> historiqueCalculs = new ArrayList<>();;
    private ListView<String> historiqueListView = new ListView<>();


    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Calculatrice");
        // Configuration de la disposition en grille
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(10));
        gridPane.setLayoutY(20);
        //création du menu
        MenuBar menuBar = new MenuBar();
        
        VBox vBox = new VBox(menuBar);        
        Menu menuFile = new Menu("Calculator sort");
         MenuItem menuItemBasicCalculator = new MenuItem("Basic Calculator");
         MenuItem menuItemScientificCalculator = new MenuItem("Scientific Calculator");
         menuFile.getItems().addAll(menuItemBasicCalculator, menuItemScientificCalculator);
         Menu convertMenu = new Menu("Convert");

        MenuItem menuItemMasses = new MenuItem("Masses");
        MenuItem menuItemLongueur = new MenuItem("Longueur");
        MenuItem menuItemTemperature = new MenuItem("Temperature");
        MenuItem menuItemVolumes = new MenuItem("Volumes");
        MenuItem menuItemCurrency = new MenuItem("Currency");
        

        convertMenu.getItems().addAll(menuItemMasses,menuItemLongueur,menuItemTemperature,menuItemVolumes,menuItemCurrency);
        menuBar.getMenus().addAll(menuFile,convertMenu);
 
 
         // Gestion des événements du menu
         menuItemBasicCalculator.setOnAction(e -> {
            gridPane.getChildren().clear();
            addDisplay(primaryStage,gridPane);
            primaryStage.sizeToScene();
         });
        menuItemScientificCalculator.setOnAction(e -> {
            gridPane.getChildren().clear();
            addDisplay(primaryStage,gridPane);
            ScientificCalculatorApp scientificCalculatorApp = new ScientificCalculatorApp();
            scientificCalculatorApp.ScientificDisplay(gridPane,displayField,historiqueCalculs,historiqueListView,variableNames,varListView);
            primaryStage.sizeToScene();
            
         });
         menuItemMasses.setOnAction(e -> {
            String masses[] ={ "Kilogrammes", "Grammes", "Livres","Onces" };
            gridPane.getChildren().clear();
            addDisplay(primaryStage,gridPane);
            ConversionDisplay.display(masses,gridPane,displayField,primaryStage);
        });
        menuItemLongueur.setOnAction(e -> {
            String longueurs[] ={ "Centimètres", "Pouces", "Mètres", "Pieds" };
            gridPane.getChildren().clear();
            addDisplay(primaryStage,gridPane);
            ConversionDisplay.display(longueurs,gridPane,displayField,primaryStage);
        });
        menuItemTemperature.setOnAction(e -> {
            String temperature[] ={ "Celsius", "Fahrenheit", "Kelvin" };
            gridPane.getChildren().clear();
            addDisplay(primaryStage,gridPane);
            ConversionDisplay.display(temperature,gridPane,displayField,primaryStage);
        });
        menuItemVolumes.setOnAction(e -> {
            String volumes[] ={ "Litres", "Gallons", "Mètres cubes", "Pieds cubes" };
            gridPane.getChildren().clear();
            addDisplay(primaryStage,gridPane);
            ConversionDisplay.display(volumes,gridPane,displayField,primaryStage);
        });
        menuItemCurrency.setOnAction(e -> {
            String currency[] = CurrencyConverter.readCurrency();
            
            gridPane.getChildren().clear();
            addDisplay(primaryStage,gridPane);
            ConversionDisplay.display(currency,gridPane,displayField,primaryStage);
        });
        addDisplay(primaryStage, gridPane);

        Group root = new Group(vBox,gridPane);
        Scene scene = new Scene(root);

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

    private void addDisplay(Stage primaryStage,GridPane gridPane) {
        // Création du champ d'affichage
        displayField = new TextField();
        displayField.setEditable(false);
        displayField.setAlignment(Pos.CENTER_RIGHT);
        memoryField = new TextField();
        memoryField.setPrefWidth(100);
        memoryField.setEditable(false);
        variableNameField = new TextField();
        variableNameField.setPromptText("Variable name");

        // Initialisation de l'historique des calculs

       

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
        Button buttonpoint = createButton(".");
        
        Button buttonC = createButton("C");
        Button buttonAC = createButton("AC");
        Button buttonRebate = createButton("rebate %");
        buttonRebate.setMinWidth(100);
        Button buttonIncrease = createButton("increase %");
        buttonIncrease.setMinSize(100,20);
        Button buttonPartOf = createButton("part of");
        buttonPartOf.setMinWidth(100);
        Button buttonMemory = createButton("MS");
        Button buttonMemoryRead = createButton("MR");
        Button buttonMemoryClear = createButton("MC");
        Button saveVariableButton = createButton("Save Variable");
        

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
        gridPane.add(buttonpoint,4,4);
        gridPane.add(buttonMultiply, 3, 3);
        gridPane.add(button0, 0, 4);
        gridPane.add(buttonEquals, 1, 4);
        gridPane.add(buttonC, 2, 4);
        gridPane.add(buttonDivide, 3, 4);
        gridPane.add(buttonAC ,0,5 );
        gridPane.add(buttonRebate ,4,3, 2, 1 );
        gridPane.add(buttonIncrease ,4,2, 2, 1 );
        gridPane.add(buttonPartOf ,4,1, 2, 1 );
        gridPane.add(buttonMemory ,1,5 );
        gridPane.add(buttonMemoryRead ,3,5 );
        gridPane.add(buttonMemoryClear ,2,5 );
        gridPane.add(memoryField, 4, 0);
        gridPane.add(historiqueListView, 5, 0, 1, 7);
        gridPane.add(variableNameField, 0, 6, 2, 1);
        gridPane.add(saveVariableButton, 2, 6);
        gridPane.add(varListView, 6, 0, 1, 7);


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
        buttonpoint.setOnAction(e -> appendToDisplay("."));

        buttonAdd.setOnAction(e -> MainController.handleOperatorClick("+",displayField));
        buttonSubtract.setOnAction(e -> MainController.handleOperatorClick("-",displayField));
        buttonEquals.setOnAction(e ->{
        // Ajouter l'expression et le résultat à l'historique
        CalculationResult print = MainController.calculateResult(displayField);
        double operand1 = print.getOperand1();
        double operand2 = CalculationResult.getOperand2();
        String signOperator = print.getSignOperator();
        double result = print.getresult();

        String calcul = operand1 + signOperator + operand2 + " = " + result;
        historiqueCalculs.add(calcul);

        // Mettre à jour la ListView de l'historique des calculs
        historiqueListView.setItems(FXCollections.observableArrayList(historiqueCalculs));
        });
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

        historiqueListView.setOnMouseClicked(event -> {
            String calculSelectionne = historiqueListView.getSelectionModel().getSelectedItem();
            if (calculSelectionne != null) {
                String[] parts = calculSelectionne.split(" = ");
                if (parts.length == 2) {
                    String calcul = parts[0];
                    String resultat = parts[1];
                    displayField.setText(resultat);
                }
            }
        });


        saveVariableButton.setOnAction(e -> {
                String variableName = variableNameField.getText();
                String valueText = displayField.getText();
                String Value = variableName + " = " + valueText;
                int i=0;
                boolean find=false;
                for (String element : variableNames){
                    if (element.split(" = ")[0].equals(variableName)){
                        variableNames.set(i,Value);
                        find=true;
                        System.out.println("test");
                    }
                    i++;
                }
                if(!find){
                    variableNames.add(Value);
                }
                varListView.setItems(FXCollections.observableArrayList(variableNames));
        });
    
    
        varListView.setOnMouseClicked(event -> {
            String varSelectionne = varListView.getSelectionModel().getSelectedItem();
            if (varSelectionne != null) {
                String[] parts = varSelectionne.split(" = ");
                if (parts.length == 2) {
                    String res = parts[1];
                    displayField.setText(res);
                }
            }
        });
    }

    public static void main(String[] args) {
        launch();
    }
}
