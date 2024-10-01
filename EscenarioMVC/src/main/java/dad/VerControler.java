package dad;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.VBox;
import javafx.fxml.FXML;
import jdk.jfr.Label;

import java.io.IOException;

import java.net.URL;
import java.util.ResourceBundle;

public class VerControler  implements Initializable {

    private IntegerProperty value = new SimpleIntegerProperty();



    @FXML
    private VBox root;


    @FXML
    private Label valuelabel;


    public verController(){
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
            valueProgress.progressProperty().bind(value.divide(100));
            valuelabel.textProperty().bind(value.asString());
    }

    public IntegerProperty getValue() {
        return value;
    }

    public void setValue(IntegerProperty value) {
        this.value = value;
    }

    public VBox getRoot() {
        return root;
    }

    public void setRoot(VBox root) {
        this.root = root;
    }

    public Label getValuelabel() {
        return valuelabel;
    }

    public void setValuelabel(Label valuelabel) {
        this.valuelabel = valuelabel;
    }
}
