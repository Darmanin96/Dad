package dad.micv.model.adapters;

import javafx.beans.property.*;

public class Conocimiento {

    private final StringProperty denominacion = new SimpleStringProperty();

    public Conocimiento() {
    }

    public Conocimiento(String denominacion) {
        this.denominacion.set(denominacion);
    }

    public String getDenominacion() {
        return denominacion.get();
    }

    public void setDenominacion(String denominacion) {
        this.denominacion.set(denominacion);
    }

    public StringProperty denominacionProperty() {
        return denominacion;
    }
}
