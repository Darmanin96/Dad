package dad.micv.model.adapters;

import javafx.beans.property.*;

public class Nivel extends Conocimiento{

    private final IntegerProperty basico = new SimpleIntegerProperty();
    private final IntegerProperty medio = new SimpleIntegerProperty();
    private final IntegerProperty avanzado = new SimpleIntegerProperty();

    public Nivel() {
    }

    public Nivel(int basico, int medio, int avanzado, String denominacion) {
        this.basico.setValue(basico);
        this.medio.setValue(medio);
        this.avanzado.setValue(avanzado);
    }

    public int getBasico() {
        return basico.get();
    }

    public void setBasico(int basico) {
        this.basico.set(basico);
    }

    public IntegerProperty basicoProperty() {
        return basico;
    }

    public int getAvanzado() {
        return avanzado.get();
    }

    public void setAvanzado(int avanzado) {
        this.avanzado.set(avanzado);  // Setter para el nivel avanzado
    }

    public IntegerProperty avanzadoProperty() {
        return avanzado;
    }

    public int getMedio() {
        return medio.get();
    }

    public void setMedio(int medio) {
        this.medio.set(medio);  // Setter para el nivel medio
    }

    public IntegerProperty medioProperty() {
        return medio;
    }
}
