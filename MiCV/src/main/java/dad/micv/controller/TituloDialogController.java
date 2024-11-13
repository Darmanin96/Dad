package dad.micv.controller;

import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;

import java.io.*;
import java.net.*;
import java.util.*;

public class TituloDialogController implements Initializable {


    @FXML
    private Button Añadir;

    @FXML
    private Button Cancelar;

    @FXML
    private TextField Denominacion;

    @FXML
    private DatePicker Desde;

    @FXML
    private DatePicker Hasta;

    @FXML
    private TextField Organizador;

    @FXML
    private BorderPane root;

    private boolean confirmar = false;

    @FXML
    void onAñadirAction(ActionEvent event) {
        confirmar = true;
        cerrar();
    }

    private void cerrar(){
        Stage stage = (Stage) root.getScene().getWindow();
        stage.close();
    }

    public boolean isConfirmar(){
        return confirmar;
    }

    @FXML
    void onCancelAction(ActionEvent event) {
            cerrar();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public TituloDialogController() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/TituloDialogView.fxml"));
            fxmlLoader.setController(this);
            fxmlLoader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void setConfirmar(boolean confirmar) {
        this.confirmar = confirmar;
    }

    public Button getAñadir() {
        return Añadir;
    }

    public void setAñadir(Button añadir) {
        Añadir = añadir;
    }

    public Button getCancelar() {
        return Cancelar;
    }

    public void setCancelar(Button cancelar) {
        Cancelar = cancelar;
    }

    public TextField getDenominacion() {
        return Denominacion;
    }

    public void setDenominacion(TextField denominacion) {
        Denominacion = denominacion;
    }

    public DatePicker getDesde() {
        return Desde;
    }

    public void setDesde(DatePicker desde) {
        Desde = desde;
    }

    public DatePicker getHasta() {
        return Hasta;
    }

    public void setHasta(DatePicker hasta) {
        Hasta = hasta;
    }

    public TextField getOrganizador() {
        return Organizador;
    }

    public void setOrganizador(TextField organizador) {
        Organizador = organizador;
    }

    public BorderPane getRoot() {
        return root;
    }

    public void setRoot(BorderPane root) {
        this.root = root;
    }
}
