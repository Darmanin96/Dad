package dad.misamigos;

import com.google.gson.Gson;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.hildan.fxgson.FxGson;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

public class AmigosApp extends Application {

    private final  RootController rootController = new RootController();


    @Override
    public void init() throws Exception {

    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Stage stage = new Stage();
        stage.setTitle("Mis Amigos");
        stage.setScene(new Scene(rootController.getRoot()));
        stage.show();
    }


    @Override
    public void stop() throws Exception {
        File fileFriend = new File("friends.json");
        Gson gson = FxGson.fullBuilder(
                       
        );

        String json = gson.toJson(rootController.getRoot());
        Files.writeString(fileFriend.toPath(), json , StandardCharsets.UTF_8);
        System.out.println("Cambios guardados en el fichero " + fileFriend);
    }
}
