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
import java.util.*;

public class TableConocimientosController implements Initializable {


    @FXML
    private Button Eliminar;

    @FXML
    private Button añadirConocimiento;

    @FXML
    private GridPane root;

    @FXML
    private TableColumn<Nivel, String> denominacion;

    @FXML
    private TableColumn<Nivel, Integer> nivel;

    @FXML
    private TableView<Nivel> tableConocimiento;

    private ObservableList<Nivel> conocimiento = FXCollections.observableArrayList();

    @FXML
    void onAñadirConocimientoAction(ActionEvent event) {
        ConocimientoHabilidadController conocimientoHabilidadController = new ConocimientoHabilidadController();
        Stage stage = new Stage();
        stage.setTitle("Nuevo Conocimiento");
        stage.setScene(new Scene(conocimientoHabilidadController.getRoot()));
        stage.showAndWait();

        if (conocimientoHabilidadController.isConfirmar()) {
            String denominacion = conocimientoHabilidadController.getDenominacion().getText();
            String nivelSeleccionado = conocimientoHabilidadController.getNivel().getValue();
            Integer nivelEntero;
            switch (nivelSeleccionado) {
                case "Básico":
                    nivelEntero = 1;
                    break;
                case "Medio":
                    nivelEntero = 2;
                    break;
                case "Avanzado":
                    nivelEntero = 3;
                    break;
                default:
                    nivelEntero = 0;
            }

            Nivel nuevoConocimiento = new Nivel(denominacion, nivelEntero);
            conocimiento.add(nuevoConocimiento);
        }
    }

    @FXML
    void onEliminarAction(ActionEvent event) {
        Nivel selectedNivel = tableConocimiento.getSelectionModel().getSelectedItem();
        if (selectedNivel != null) {
            conocimiento.remove(selectedNivel);
        }
    }
    @FXML
    void onAñadirIdiomaAction(ActionEvent event) {
        IdiomaHabilidadController idiomaHabilidadController = new IdiomaHabilidadController();
        Stage stage = new Stage();
        stage.setTitle("Nuevo conocimiento");
        stage.setScene(new Scene(idiomaHabilidadController.getRoot()));
        stage.showAndWait();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tableConocimiento.setItems(conocimiento);
        denominacion.setCellValueFactory(cellData -> cellData.getValue().denominacionProperty());
        nivel.setCellValueFactory(cellData -> cellData.getValue().nivelProperty().asObject());
    }
}
