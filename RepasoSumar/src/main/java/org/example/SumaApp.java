package org.example;

import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;

public class SumaApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        RootController rootController = new RootController();
        Stage stage1 = new Stage();
        stage1.setTitle("Sumar dos números ");
        stage1.setScene(new Scene(rootController.getRoot()));
        stage1.show();
    }
}
