package dad;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.fxml.FXML;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class VerControler implements Initializable {

    // Propiedad Integer para el valor
    private IntegerProperty value = new SimpleIntegerProperty();

    @FXML
    private VBox root;

    @FXML
    private Label valuelabel;

    // Constructor que carga el archivo FXML correcto
    public VerControler() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/VerView.fxml"));
            fxmlLoader.setController(this);
            fxmlLoader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // Inicializa los enlaces de propiedades
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Enlazamos el valor de la etiqueta con la propiedad 'value'
        valuelabel.textProperty().bind(value.asString());
    }

    // Métodos getter y setter para 'value'
    public IntegerProperty getValue() {
        return value;
    }

    public void setValue(IntegerProperty value) {
        this.value = value;
    }

    // Métodos getter y setter para 'root'
    public VBox getRoot() {
        return root;
    }

    public void setRoot(VBox root) {
        this.root = root;
    }

    // Métodos getter y setter para 'valuelabel'
    public Label getValuelabel() {
        return valuelabel;
    }

    public void setValuelabel(Label valuelabel) {
        this.valuelabel = valuelabel;
    }
}
