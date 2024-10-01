package dad;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;


public class EscenarioApp extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {
        ModificarControler modificarControler = new ModificarControler();
        Stage modificarstage = new Stage();
        modificarstage.setTitle("Modificar");
        modificarstage.setScene(new Scene(modificarControler.getroot()));
        modificarstage.show();

        /*ModificarControler verControler = new ModificarControler();
        Stage verstage = new Stage();
        modificarstage.setTitle("Ver");
        modificarstage.setScene(new Scene(verControler.getroot()));
        modificarstage.show();

        verControler.valueProperty().bind(modificarControler.valueProperty());*/
    }
}
