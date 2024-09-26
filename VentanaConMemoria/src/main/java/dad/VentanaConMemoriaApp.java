package dad;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;
import javafx.scene.Scene;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.control.Slider;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;


public class VentanaConMemoriaApp extends Application {

    private DoubleProperty x = new SimpleDoubleProperty();
    private DoubleProperty y = new SimpleDoubleProperty();
    private DoubleProperty with = new SimpleDoubleProperty();
    private DoubleProperty high = new SimpleDoubleProperty();

    @Override
    public void init() throws Exception {
        super.init();
        System.out.println("Iniciando");

        File profileFolder = new File(System.getProperty("user.home"));
        File configFolder = new File(profileFolder, ".VentanaConMemoria");
        File configFile = new File(configFolder, "config.properties");

        if (configFile.exists()) {
            FileInputStream fis = new FileInputStream(configFile);
         Properties prop = new Properties();
         prop.load(fis);
        with.set(Double.parseDouble(prop.getProperty("size.with: ")));
        high.set(Double.parseDouble(prop.getProperty("size.high: ")));
        x.set(Double.parseDouble(prop.getProperty("location.x: ")));
        y.set(Double.parseDouble(prop.getProperty("location.y: ")));
        }else {
            with.set(320);
            high.set(200);
            x.set(0);
            y.set(0);
        }

    }


    @Override
    public void start(Stage primaryStage) throws Exception {


        Slider redslider = new Slider();
        redslider.setMin(0);
        redslider.setMax(255);
        redslider.setShowTickLabels(true);
        

        VBox root = new VBox();

        Scene scene = new Scene(root,with.get(),high.get());
        primaryStage.setX(x.get());
        primaryStage.setY(y.get());
        primaryStage.setTitle("Ventana con memoria");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    @Override
    public void stop() throws Exception {
        super.stop();
        System.out.println("Cerrado");
        File profileFolder = new File(System.getProperty("user.home"));
        File configFolder = new File(profileFolder, ".VentanaConMemoria");
        File configFile = new File(configFolder, "config.properties");

        if (!configFile.exists()) {
            configFolder.mkdir();
        }

        System.out.println("Profile    : " +  profileFolder);
        System.out.println("Config folder    : " + configFolder);
        System.out.println("Config file  : " + configFile);

        FileOutputStream fos = new FileOutputStream("config.properties");

        Properties props = new Properties();
        props.setProperty("size width: ","" + with.get());
        props.setProperty("size height: ","" + high.get());
        props.setProperty("location x: ","" + x.get());
        props.setProperty("location y: ","" + y.get());
        props.store(fos,"Estado de la ventana");
    }
}
