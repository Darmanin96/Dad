package org.example;

import javafx.application.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.stage.*;

public class VentanaApp extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {
        PrincipalController pc = new PrincipalController();
        Stage stage = new Stage();
        stage.setTitle("Ventana App");
        stage.setScene(new Scene(pc.getRoot()));
        stage.show();
    }
}
