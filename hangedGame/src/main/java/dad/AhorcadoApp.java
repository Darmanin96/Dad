package dad;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AhorcadoApp extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/RootView.fxml"));
        primaryStage.setTitle("Ahorcado");
        primaryStage.setScene(new Scene(loader.load())); // Carga directamente el archivo FXML
        primaryStage.show();
    }
}
