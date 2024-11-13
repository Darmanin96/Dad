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

public class TableConocimientosController implements Initializable {


    @FXML
    private Button Eliminar;

    @FXML
    private Button añadirConocimiento;

    @FXML
    private Button añadirIdioma;

    @FXML
    private GridPane root;

    @FXML
    private TableColumn<Nivel, Integer> denominacion;

    @FXML
    private TableColumn<Nivel, Integer> nivel;

    @FXML
    private TableView<?> tableConocimiento;

    private ObservableList<Experiencia> conocimiento = FXCollections.observableArrayList();

    @FXML
    void onAñadirConocimientoAction(ActionEvent event) {
        ConocimientoHabilidadController conocimientoHabilidadController = new ConocimientoHabilidadController();
        Stage stage = new Stage();
        stage.setTitle("Nuevo Conocimiento");
        stage.setScene(new Scene(conocimientoHabilidadController.getRoot()));
        stage.showAndWait();



    }

    @FXML
    void onAñadirIdiomaAction(ActionEvent event) {

    }

    @FXML
    void onEliminarAction(ActionEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }


    public Button getEliminar() {
        return Eliminar;
    }

    public void setEliminar(Button eliminar) {
        Eliminar = eliminar;
    }

    public Button getAñadirConocimiento() {
        return añadirConocimiento;
    }

    public void setAñadirConocimiento(Button añadirConocimiento) {
        this.añadirConocimiento = añadirConocimiento;
    }

    public Button getAñadirIdioma() {
        return añadirIdioma;
    }

    public void setAñadirIdioma(Button añadirIdioma) {
        this.añadirIdioma = añadirIdioma;
    }

    public GridPane getRoot() {
        return root;
    }

    public void setRoot(GridPane root) {
        this.root = root;
    }

    public TableView<?> getTableConocimiento() {
        return tableConocimiento;
    }

    public void setTableConocimiento(TableView<?> tableConocimiento) {
        this.tableConocimiento = tableConocimiento;
    }
}
