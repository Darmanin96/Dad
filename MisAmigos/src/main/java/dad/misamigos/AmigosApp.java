package dad.misamigos;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AmigosApp extends Application {

    private final  RootController rootController = new RootController();

    @Override
    public void start(Stage primaryStage) throws Exception {

        Stage stage = new Stage();
        stage.setTitle("Mis Amigos");
        stage.setScene(new Scene(rootController.getRoot()));
        stage.show();
    }
}
