package job04;
import javafx.application.Application;
import javafx.stage.Stage;

public class MainApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        BasicCalculatorApp basicCalculatorApp = new BasicCalculatorApp();
        basicCalculatorApp.start(primaryStage);
    }

    public static void main(String[] args) {
        launch();
    }
}
