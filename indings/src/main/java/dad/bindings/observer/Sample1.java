package dad.bindings.observer;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Sample1 {
    public static void main(String[] args) {

        StringProperty nombre = new SimpleStringProperty();
        StringProperty apellido = new SimpleStringProperty();
        StringProperty nombreCompleto = new SimpleStringProperty();
        nombreCompleto.bind(nombreCompleto.concat(" ").concat(apellido));
        nombreCompleto.addListener((observable, oldValue, newValue) -> {
            System.out.println("Nombre completo: "  + newValue);
        });
        nombre.set("Chuck");
        apellido.set("Norris");
        apellido.set("Stallone");

    }

}
