package org.example;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;

public class Ventana1Controller {

    @FXML
    private Button btnAbrirVentana2;

    @FXML
    private void abrirVentana2() throws Exception {
        Stage stage = (Stage) btnAbrirVentana2.getScene().getWindow(); // Obtiene el Stage actual
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/Ventana2.fxml")); // Carga Ventana2.fxml
        stage.setScene(new Scene(root)); // Cambia la escena
        stage.setTitle("Ventana 2"); // Actualiza el título de la ventana
        stage.show();
    }
}
