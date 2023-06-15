package job04.classes;
import javafx.collections.FXCollections;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ConversionDisplay {
    private static TextField convertedField;

    public static void display(String[] types,GridPane gridPane,TextField displayField,Stage primaryStage){
        displayField.clear();
        gridPane.getChildren().removeIf( node -> GridPane.getColumnIndex(node) == 4 && GridPane.getRowIndex(node) == 0);
        gridPane.getChildren().removeIf( node -> GridPane.getColumnIndex(node) == 4 && GridPane.getRowIndex(node) == 1);
        gridPane.getChildren().removeIf( node -> GridPane.getColumnIndex(node) == 4 && GridPane.getRowIndex(node) == 2);
        gridPane.getChildren().removeIf( node -> GridPane.getColumnIndex(node) == 4 && GridPane.getRowIndex(node) == 3);
        gridPane.getChildren().removeIf( node -> GridPane.getColumnIndex(node) == 4 && GridPane.getRowIndex(node) == 4);
        gridPane.getChildren().removeIf( node -> GridPane.getColumnIndex(node) == 4 && GridPane.getRowIndex(node) == 5);
        gridPane.getChildren().removeIf( node -> GridPane.getColumnIndex(node) == 5 && GridPane.getRowIndex(node) == 4);
        gridPane.getChildren().removeIf( node -> GridPane.getColumnIndex(node) == 5 && GridPane.getRowIndex(node) == 5);
        gridPane.getChildren().removeIf( node -> GridPane.getColumnIndex(node) == 3 && GridPane.getRowIndex(node) == 1);
        gridPane.getChildren().removeIf( node -> GridPane.getColumnIndex(node) == 3 && GridPane.getRowIndex(node) == 2);
        gridPane.getChildren().removeIf( node -> GridPane.getColumnIndex(node) == 3 && GridPane.getRowIndex(node) == 3);
        gridPane.getChildren().removeIf( node -> GridPane.getColumnIndex(node) == 3 && GridPane.getRowIndex(node) == 4);
        gridPane.getChildren().removeIf( node -> GridPane.getColumnIndex(node) == 1 && GridPane.getRowIndex(node) == 4);
        gridPane.getChildren().removeIf( node -> GridPane.getColumnIndex(node) == 5 && GridPane.getRowIndex(node) == 0);
        gridPane.getChildren().removeIf( node -> GridPane.getColumnIndex(node) == 5 && GridPane.getRowIndex(node) == 6);
        gridPane.getChildren().removeIf( node -> GridPane.getColumnIndex(node) == 0 && GridPane.getRowIndex(node) == 5);
        gridPane.getChildren().removeIf( node -> GridPane.getColumnIndex(node) == 1 && GridPane.getRowIndex(node) == 5);
        gridPane.getChildren().removeIf( node -> GridPane.getColumnIndex(node) == 2 && GridPane.getRowIndex(node) == 5);
        gridPane.getChildren().removeIf( node -> GridPane.getColumnIndex(node) == 3 && GridPane.getRowIndex(node) == 5);
        gridPane.getChildren().removeIf( node -> GridPane.getColumnIndex(node) == 0 && GridPane.getRowIndex(node) == 6);
        gridPane.getChildren().removeIf( node -> GridPane.getColumnIndex(node) == 2 && GridPane.getRowIndex(node) == 6);
        gridPane.getChildren().removeIf( node -> GridPane.getColumnIndex(node) == 3 && GridPane.getRowIndex(node) == 6);
        gridPane.getChildren().removeIf( node -> GridPane.getColumnIndex(node) == 6 && GridPane.getRowIndex(node) == 0);
        
        // Create a combo box
        ComboBox<String> fromUnit =new ComboBox<String>(FXCollections.observableArrayList(types));
        ComboBox<String> toUnit =new ComboBox<String>(FXCollections.observableArrayList(types));
        
        Button buttonConvert = createButton("convertir");
        Button buttonPoint = createButton(".");
        convertedField=new TextField();
        convertedField.setAlignment(Pos.CENTER_RIGHT);
        gridPane.add(convertedField, 0, 6,4,1);
        gridPane.add(buttonConvert, 0, 7);
        gridPane.add(buttonPoint, 1, 4);
        gridPane.add(fromUnit,5,0);
        gridPane.add(toUnit,5,6);
        buttonPoint.setOnAction(e -> {
            if(displayField.getText().indexOf('.')==-1){
                appendToDisplay(".",displayField);
            }
            
        });
        buttonConvert.setOnAction(e -> ConversionController.calculateResult(displayField,convertedField,fromUnit.getValue(),toUnit.getValue()));
        primaryStage.sizeToScene();
    }

    private static Button createButton(String text) {
        Button button = new Button(text);
        button.setPrefSize(70, 30);
        return button;
    }

    private static void appendToDisplay(String text,TextField displayField) {
        displayField.setText(displayField.getText() + text);
    }   
}