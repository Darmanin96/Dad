package dad;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class EscenarioApp extends Application {

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

        // Enlazar la propiedad 'value' de ambos controladores para sincronizarlos
        verControler.getValue().bindBidirectional(modificarControler.getValue());
    }

}
