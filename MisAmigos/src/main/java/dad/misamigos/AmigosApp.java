package dad.misamigos;

import com.google.gson.*;
import dad.misamigos.adapters.*;
import dad.misamigos.controllers.RootController;
import dad.misamigos.model.*;
import javafx.application.Application;
import javafx.beans.property.*;
import javafx.scene.Scene;
import javafx.scene.image.*;
import javafx.stage.Stage;
import org.hildan.fxgson.*;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.time.*;

public class AmigosApp extends Application {


    private final RootController rootController = new RootController();

    @Override
    public void init() throws Exception {
        // Inicialización adicional si es necesario

    private static final File DATA_DIR = new File(("user.home"),".MisAmigos");
    private static final File FRIEND_FILE = new File(DATA_DIR,"friends.json");

    private final Gson gson = FxGson.fullBuilder()
            .setPrettyPrinting()
            .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
            .registerTypeAdapter(Image.class, new ImageAdapter())
            .create();

    private final RootController rootController = new RootController();


    @Override
    public void init() throws Exception {
        if (FRIEND_FILE.exists()) {
            String json = Files.readString(FRIEND_FILE.toPath(), StandardCharsets.UTF_8);
            ListProperty<Friend> friends = gson.fromJson(json, FriendList.class);
            rootController.getFriends().setAll(friends);
            System.out.println(friends.size() + "contactos leídos desde el fichero: " + FRIEND_FILE);
        }

    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("Mis Amigos");
        primaryStage.setScene(new Scene(rootController.getRoot()));

        Stage stage = new Stage();
        stage.setTitle("Mis Amigos");
        stage.setScene(new Scene(rootController.getRoot()));
        stage.show();

    }

    @Override
    public void stop() throws Exception {

        File fileFriend = new File("friends.json");
        Gson gson = FxGson.fullBuilder()
                .setPrettyPrinting()
                .create(); // Se debe crear el Gson con el builder
        String json = gson.toJson(rootController.getFriends());
        Files.writeString(fileFriend.toPath(), json, StandardCharsets.UTF_8);
        System.out.println("Cambios guardados en el fichero " + fileFriend);

        if (!DATA_DIR.exists()) {
            DATA_DIR.mkdir();
        }else {
            String json = gson.toJson(rootController.getFriends());
            Files.writeString(FRIEND_FILE.toPath(), json , StandardCharsets.UTF_8);
            System.out.println("Cambios guardados en el fichero " + FRIEND_FILE);
        }
    }
}
