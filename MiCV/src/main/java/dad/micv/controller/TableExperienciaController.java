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

public class TableExperienciaController implements Initializable {
    @FXML
    private Button Añadir;

    @FXML
    private TableColumn<Experiencia, String> Denominacion;

    @FXML
    private TableColumn<Experiencia, LocalDate> Desde;

    @FXML
    private Button Eliminar;

    @FXML
    private TableColumn<Experiencia, String> Empleador;

    @FXML
    private TableColumn<Experiencia, LocalDate> Hasta;

    @FXML
    private GridPane root;

    @FXML
    private TableView<Experiencia> tableExperiencia;

    private ObservableList<Experiencia> experiencia = FXCollections.observableArrayList();

    @FXML
    void onAñadirAction(ActionEvent event) {
        TituloDialogController tituloDialogController = new TituloDialogController();
        Stage stage = new Stage();
        stage.setTitle("Nueva Experiencia");
        stage.setScene(new Scene(tituloDialogController.getRoot()));
        stage.showAndWait();

        if (tituloDialogController.isConfirmar()){
            Experiencia Experiencia = new Experiencia();
            tituloDialogController.getDenominacion();
            tituloDialogController.getDesde();
            tituloDialogController.getHasta();
            tituloDialogController.getOrganizador();
            experiencia.add(Experiencia);
        }
    }

    @FXML
    void onEliminarAction(ActionEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
            tableExperiencia.setItems(experiencia);
            Desde.setCellValueFactory(cellData -> cellData.getValue().desdeProperty());
            Hasta.setCellValueFactory(cellData -> cellData.getValue().hastaProperty());
            Denominacion.setCellValueFactory(cellData -> cellData.getValue().denominacionProperty());
            Empleador.setCellValueFactory(cellData -> cellData.getValue().empleadorProperty());


        Desde.textProperty().addListener((obs, oldText, newText) -> {
            Experiencia experiencia = tableExperiencia.getSelectionModel().getSelectedItem();
            if (experiencia != null) {
                experiencia.setDesde(LocalDate.parse(newText));
            }
        });


    }

    public Button getAñadir() {
        return Añadir;
    }

    public void setAñadir(Button añadir) {
        Añadir = añadir;
    }

    public TableColumn<Experiencia, String> getDenominacion() {
        return Denominacion;
    }

    public void setDenominacion(TableColumn<Experiencia, String> denominacion) {
        Denominacion = denominacion;
    }

    public TableColumn<Experiencia, LocalDate> getDesde() {
        return Desde;
    }

    public void setDesde(TableColumn<Experiencia, LocalDate> desde) {
        Desde = desde;
    }

    public Button getEliminar() {
        return Eliminar;
    }

    public void setEliminar(Button eliminar) {
        Eliminar = eliminar;
    }

    public TableColumn<Experiencia, String> getEmpleador() {
        return Empleador;
    }

    public void setEmpleador(TableColumn<Experiencia, String> empleador) {
        Empleador = empleador;
    }

    public ObservableList<Experiencia> getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(ObservableList<Experiencia> experiencia) {
        this.experiencia = experiencia;
    }

    public TableColumn<Experiencia, LocalDate> getHasta() {
        return Hasta;
    }

    public void setHasta(TableColumn<Experiencia, LocalDate> hasta) {
        Hasta = hasta;
    }

    public GridPane getRoot() {
        return root;
    }

    public void setRoot(GridPane root) {
        this.root = root;
    }

    public TableView<Experiencia> getTableExperiencia() {
        return tableExperiencia;
    }

    public void setTableExperiencia(TableView<Experiencia> tableExperiencia) {
        this.tableExperiencia = tableExperiencia;
    }
}
