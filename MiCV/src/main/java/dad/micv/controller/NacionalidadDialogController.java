package dad.micv.controller;

import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;

import java.io.*;
import java.net.*;
import java.util.*;

public class NacionalidadDialogController implements Initializable {

    @FXML
    private ChoiceBox<String> nacionalidad;

    @FXML
    private BorderPane root;

    public NacionalidadDialogController() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/NacionalidadDialogView.fxml"));
            fxmlLoader.setController(this);
            fxmlLoader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            cargarNacionalidad();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void cargarNacionalidad() {
        List<String> nacionalidades = new ArrayList<>();
        String archivo = "C:\\Users\\darma\\Documents\\GitHub\\Dad\\MiCV\\src\\main\\resources\\csv\\nacionalidades.csv";
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                nacionalidades.add(linea);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        nacionalidad.getItems().addAll(nacionalidades);
    }

    public String showDialog() {
        Dialog<String> dialog = new Dialog<>();
        dialog.setTitle("Seleccionar Nacionalidad");
        dialog.getDialogPane().setContent(root);
        dialog.getDialogPane().getButtonTypes().add(javafx.scene.control.ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(javafx.scene.control.ButtonType.CANCEL);
        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == javafx.scene.control.ButtonType.OK) {
                return nacionalidad.getValue();
            }
            return null;
        });
        Optional<String> result = dialog.showAndWait();
        return result.orElse(null);
    }

    public ChoiceBox<String> getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(ChoiceBox<String> nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public BorderPane getRoot() {
        return root;
    }

    public void setRoot(BorderPane root) {
        this.root = root;
    }
}
