package Pestañas;

import dad.gesaula.ui.model.*;
import javafx.collections.FXCollections;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.input.*;
import javafx.scene.layout.*;

import java.io.*;
import java.net.*;
import java.time.LocalDate;
import java.util.*;

public class AlumnoController implements Initializable {

    @FXML
    private Tab Alumn;

    @FXML
    private Button Delete;

    @FXML
    private Tab Group;

    @FXML
    private TextField NameFichero;

    @FXML
    private Button New;

    @FXML
    private Button Save;

    @FXML
    private TabPane TabAlumn;

    @FXML
    private TableView<?> alumnoTableView;

    @FXML
    private TableColumn<?, ?> apellidosColumn;

    @FXML
    private TableColumn<?, ?> fechaNacimientoColumn;

    @FXML
    private TableColumn<?, ?> nombreColumn;

    @FXML
    private BorderPane root;

    public AlumnoController() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/AlumnView.fxml"));
            fxmlLoader.setController(this);
            fxmlLoader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    void onNewAction(ActionEvent event) {

    }

    @FXML
    void NombreFichero(ActionEvent event) {

    }

    @FXML
    void onAlumnChanged(ActionEvent event) {

    }

    @FXML
    void onDeleteAction(ActionEvent event) {

    }

    @FXML
    void onGroupChange(ActionEvent event) {

    }

    @FXML
    void onSaveAction(MouseEvent event) {

    }
}
