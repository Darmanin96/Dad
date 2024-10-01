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
import javafx.scene.control.Alert;

import java.util.Random;

public class AdivinaApp extends Application {

    private TextField numeroTexto;
    private Button adivinarButton;
    private Label resultadoLabel;
    private int numeroAleatrio;
    private int contador=0;

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Adivina App");
        numeroAleatrio = new Random().nextInt(100) + 1;

        numeroTexto = new TextField();
        numeroTexto.setPromptText("Introduce un número");

        adivinarButton = new Button("Adivinar");
        adivinarButton.setDefaultButton(true);
        resultadoLabel = new Label();

        VBox vBox = new VBox(10);
        HBox numeroBox = new HBox(10, new Label("Introduce un número del 1 al 100"), numeroTexto);
        HBox adivinarBox = new HBox(10, adivinarButton);

        numeroBox.setAlignment(Pos.CENTER);
        adivinarBox.setAlignment(Pos.CENTER);
        vBox.getChildren().addAll(numeroBox, adivinarBox, resultadoLabel);
        vBox.setAlignment(Pos.CENTER);

        adivinarButton.setOnAction(e -> adivinarNumero(numeroAleatrio,numeroTexto,contador));

        stage.setScene(new Scene(vBox, 300, 250));
        stage.show();
    }

    private void adivinarNumero(int numeroAleatrio, TextField numeroTexto,int contador) {
        int numero2 = Integer.parseInt(numeroTexto.getText());
        if (numeroAleatrio != numero2) {
            if (numeroAleatrio < numero2) {
                contador++;
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Adivina App");
                alert.setHeaderText("Has fallado!");
                alert.setContentText("El numero del 1 al 100 es menor que " + numero2);
                alert.showAndWait();
            } else {
                contador++;
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Adivina App");
                alert.setContentText("El numero del 1 al 100 es mayor que " + numero2);

            }
        } else if (contador == numeroAleatrio) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Adivina App");
            alert.setHeaderText("Has acertado!");

        }
    }


}
