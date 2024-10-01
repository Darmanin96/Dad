package dad;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import javafx.scene.layout.VBox;
import javafx.fxml.FXML;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.control.TextField;


public class ModificarControler implements Initializable {

    private IntegerProperty value = new SimpleProperty();
    private IntegerProperty temp = new SimpleIntegerProperty();

    @FXML
    private TextField valueField;
    private VBox vbox;


    public ModificarControler() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/ModificarView.fxml"));
            fxmlLoader.setController(this);
            fxmlLoader.load();
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        valueText.textProperty().bindBidirectional(temp,new NumberStringConvert());
    }

    @FXML
    public void onDecrementAction(ActionEvent event) {
            System.out.println("decrementar");
            setValue(getValue() -1);
    }

    @FXML
    public void onIncrementAction(ActionEvent event) {

    }

    @FXML
    public void onSetAction(ActionEvent event) {
        System.out.println("establecer");
        int value = Integer.parseInt(valueField.getText());
        setValue(value);
    }

    public VBox getroot() {
        return vbox;
    }


    public TextField getValueField() {
        return valueField;
    }

    public void setValueField(TextField valueField) {
        this.valueField = valueField;
    }

    public VBox getVbox() {
        return vbox;
    }

    public void setVbox(VBox vbox) {
        this.vbox = vbox;
    }

    public IntegerProperty getValue() {
        return value;
    }

    public void setValue(IntegerProperty value) {
        this.value = value;
    }
}
