package dad.micv.model.adapters;

import javafx.beans.property.*;

public class Nivel extends Conocimiento {

    private final IntegerProperty nivel = new SimpleIntegerProperty();

    public Nivel() {
    }

    public Nivel(String denominacion, int nivel) {
        super(denominacion);
        this.nivel.set(nivel);
    }

    public int getNivel() {
        return nivel.get();
    }

    public void setNivel(int nivel) {
        this.nivel.set(nivel);
    }

    public IntegerProperty nivelProperty() {
        return nivel;
    }
}
