package dad;

import javafx.application.Application;
import javafx.scene.control.*;
import javafx.scene.control.skin.*;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.*;

public class EscenarioApp extends Application {

    private TextField textField;

    @Override
    public void start(Stage primaryStage) throws Exception {
        ModificarControler modificarControler = new ModificarControler();
        Stage modificarStage = new Stage();
        modificarStage.setTitle("Modificar");
        modificarStage.setScene(new Scene(modificarControler.getroot()));
        modificarStage.show();

        VerControler verControler = new VerControler();
        Stage verStage = new Stage();
        verStage.setTitle("Ver");
        verStage.setScene(new Scene(verControler.getRoot()));
        verStage.show();


        verControler.getValue().bindBidirectional(modificarControler.getValue());

    }

}
