package job04.classes;

import javafx.scene.control.TextField;

public class MemorySave {

    private static String memory;
    
    public static void memorySave(String value,TextField memoryField,TextField displayField) {
        memory=value;
        memoryField.setText(memory);
        displayField.clear();
	}
	
	public static void memoryRead(TextField displayField) {
        displayField.setText(memory);
	}

    public static void memoryClear(TextField memoryField) {
        memory="";
        memoryField.clear();
	}
}
