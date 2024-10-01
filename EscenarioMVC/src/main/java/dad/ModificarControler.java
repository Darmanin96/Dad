package dad;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.layout.VBox;
import javafx.scene.control.TextField;
import javafx.util.converter.NumberStringConverter;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import java.io.IOException;

public class ModificarControler implements Initializable {

    private IntegerProperty value = new SimpleIntegerProperty();
    private IntegerProperty temp = new SimpleIntegerProperty();

    @FXML
    private TextField valueText;
    @FXML
    private VBox root;

    public ModificarControler() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/ModificarView.fxml"));
            fxmlLoader.setController(this);
            fxmlLoader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        valueText.textProperty().bindBidirectional(temp, new NumberStringConverter());
    }

    @FXML
    public void onDecrementAction(ActionEvent event) {
        System.out.println("Decrementar");
        //setValue(getValue() - 1); // Decrementar el valor
    }

    @FXML
    public void onIncrementAction(ActionEvent event) {
        System.out.println("Incrementar");
        //setValue(getValue() + 1); // Incrementar el valor
    }

    @FXML
    public void onSetAction(ActionEvent event) {
        System.out.println("Establecer");
        int value = Integer.parseInt(valueText.getText());
        setValue(value);
    }

    public VBox getroot() {
        return root;
    }

    public IntegerProperty getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value.set(value); // Cambiar valor de la propiedad
    }

    public IntegerProperty valueProperty() {
        return value;
    }
}
