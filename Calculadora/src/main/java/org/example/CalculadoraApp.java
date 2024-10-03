package org.example;

import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;

public class CalculadoraApp extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        VerControler verControler = new VerControler();
        Stage verStage = new Stage();
        verStage.setTitle("Calculadora");
        verStage.setScene(new Scene(verControler.getRoot()));
        verStage.show();
    }
}
