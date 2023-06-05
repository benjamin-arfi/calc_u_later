package job04.classes;

import javafx.scene.control.TextField;

public class DisplayNumber {
    public static void displayNumber(String number,TextField displayField) {
        String currentValue= displayField.getText();
        displayField.setText(currentValue+number);
    }
}
