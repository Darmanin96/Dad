package dad.micv.ui;

import dad.micv.controller.*;
import javafx.application.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.stage.*;

public class MiCVApp extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        RootControler root = new RootControler();
        Stage verStage = new Stage();
        verStage.setTitle("MiCV");
        verStage.setScene(new Scene(root.getRoot()));
        verStage.show();
    }
}
