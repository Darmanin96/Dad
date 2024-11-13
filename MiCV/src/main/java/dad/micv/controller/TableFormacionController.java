package dad.micv.controller;

import dad.micv.model.adapters.*;
import javafx.collections.*;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;

import java.net.*;
import java.time.*;
import java.util.*;

public class TableFormacionController implements Initializable {


    @FXML
    private Button Añadir;

    @FXML
    private TableColumn<Titulo, String> Denominacion;

    @FXML
    private TableColumn<Titulo, LocalDate> Desde;

    @FXML
    private Button Eliminar;

    @FXML
    private TableColumn<Titulo, LocalDate> Hasta;

    @FXML
    private TableColumn<Titulo, String> Organizador;

    @FXML
    private GridPane root;

    @FXML
    private TableView<Titulo> tableFormacion;

    private ObservableList<Titulo> formacion = FXCollections.observableArrayList();


    @FXML
    void onAñadirAction(ActionEvent event) {
        TituloFormacionController tituloFormacionController = new TituloFormacionController();
        Stage stage = new Stage();
        stage.setTitle("Nuevo Título");
        stage.setScene(new Scene(tituloFormacionController.getRoot()));
        stage.showAndWait();


        if (tituloFormacionController.isConfirmar()){
            String denominacion = tituloFormacionController.getDenominacion().getText();
            String organizador = tituloFormacionController.getOrganizador().getText();
            LocalDate desde = tituloFormacionController.getDesde().getValue();
            LocalDate hasta = tituloFormacionController.getHasta().getValue();
            Titulo titulo1 = new Titulo(denominacion, organizador, desde, hasta);
            formacion.add(titulo1);
        }

    }

    @FXML
    void onEliminarAction(ActionEvent event) {
        Titulo titulo = tableFormacion.getSelectionModel().getSelectedItem();
        if (titulo != null){
            formacion.remove(titulo);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tableFormacion.setItems(formacion);
        Desde.setCellValueFactory(cellData -> cellData.getValue().desdeProperty());
        Hasta.setCellValueFactory(cellData -> cellData.getValue().hastaProperty());
        Denominacion.setCellValueFactory(cellData -> cellData.getValue().denominacionProperty());
        Organizador.setCellValueFactory(cellData -> cellData.getValue().organizadorProperty());
    }
}


