package dad;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Random;


public class AdivinaApp extends Application {

    private TextField numeroTexto;
    private Button adivinarButton;

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Adivina App");
        numeroTexto = new TextField();
        numeroTexto.setPromptText("Numero");
        adivinarButton = new Button("Adivinar");
        adivinarButton.setDefaultButton(true);
        VBox vBox = new VBox();
        HBox numeroBox = new HBox(10, new Label("Introduce un número del 1 al 100"), numeroTexto);
        numeroBox.setAlignment(Pos.CENTER);
        adivinarButton.setAlignment(Pos.CENTER);
        vBox.getChildren().addAll(numeroBox, adivinarButton);
        adivinarButton.setOnAction(e -> adivinarNumero());
        stage.setScene(new Scene(vBox, 300, 250));
        stage.show();
    }

    private void adivinarNumero() {

    }
}
