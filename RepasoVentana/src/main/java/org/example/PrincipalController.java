package org.example;

import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;

import java.io.*;
import java.net.*;
import java.util.*;

public class PrincipalController implements Initializable {
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }


    public PrincipalController(){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/VentanaPrincipal.fxml"));
            fxmlLoader.setController(this);
            fxmlLoader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    private TextField Text;

    @FXML
    private Button boton;

    @FXML
    private AnchorPane root;

    @FXML
    void onButtonAction(ActionEvent event) {
            SecundariaVentana ventana = new SecundariaVentana();
            Stage stage = new Stage();
            stage.setTitle("Secundaria Ventana");
            stage.setScene(new Scene(ventana.getRoot()));
            stage.show();
    }

    public TextField getText() {
        return Text;
    }

    public void setText(TextField text) {
        Text = text;
    }

    public Button getBoton() {
        return boton;
    }

    public void setBoton(Button boton) {
        this.boton = boton;
    }

    public AnchorPane getRoot() {
        return root;
    }

    public void setRoot(AnchorPane root) {
        this.root = root;
    }
}
