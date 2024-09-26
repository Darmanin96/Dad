package cel2farç;

import javafx.application.Application;
import javafx.beans.binding.DoubleBinding;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.converter.NumberStringConverter;

public class Cel2far extends Application {
    private TextField celsiusTextField, farenTextField;
    private DoubleProperty celsiusProperty, farenProperty;

    @Override
    public void start(Stage stage) throws Exception {

        celsiusProperty = new SimpleDoubleProperty();
        farenProperty = new SimpleDoubleProperty();


        celsiusTextField = new TextField();
        farenTextField = new TextField();


        celsiusTextField.setPromptText("Enter Celsius");
        farenTextField.setPromptText("Fahrenheit");
//        farenTextField.setDisable(true);
        farenTextField.setEditable(false);

        HBox celsiusBox = new HBox(5, new Label("Celsius:"), celsiusTextField);
        celsiusBox.setAlignment(Pos.BASELINE_CENTER);
        HBox farenBox = new HBox(5, new Label("Fahrenheit:"), farenTextField);
        farenBox.setAlignment(Pos.BASELINE_CENTER);
        celsiusBox.setAlignment(Pos.CENTER);
        farenBox.setAlignment(Pos.CENTER);

        VBox vbox = new VBox(10, celsiusBox, farenBox);
        vbox.setAlignment(Pos.CENTER);

        Scene scene = new Scene(vbox, 320, 200);
        stage.setTitle("Celsius to Fahrenheit Converter");
        stage.setScene(scene);
        stage.show();

        celsiusTextField.textProperty().bindBidirectional(celsiusProperty, new NumberStringConverter());
        farenTextField.textProperty().bind(farenProperty.asString("%.2f"));

        farenProperty.bind(celsiusProperty.multiply(9.0 / 5.0).add(32));
    }

}
