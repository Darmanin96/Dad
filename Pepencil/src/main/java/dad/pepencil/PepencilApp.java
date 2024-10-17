package dad.pepencil;

import dad.pepencil.controllers.*;
import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;

public class PepencilApp extends Application {

    private RootController rootController = new RootController();


    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Pepencil");
        primaryStage.setScene(new Scene(rootController.getRoot()));
        primaryStage.show();
    }
}
