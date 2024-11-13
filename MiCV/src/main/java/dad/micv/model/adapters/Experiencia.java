package dad.micv.model.adapters;

import javafx.beans.property.*;

import java.time.*;

public class Experiencia {

    private final ObjectProperty<LocalDate> desde = new SimpleObjectProperty<>();
    private final ObjectProperty<LocalDate> hasta = new SimpleObjectProperty<>();
    private final StringProperty denominacion = new SimpleStringProperty();
    private final StringProperty empleador = new SimpleStringProperty();

    // Constructor vacío
    public Experiencia() {
    }

    public Experiencia(String denominacion, String empleador, LocalDate desde, LocalDate hasta) {
        this.denominacion.set(denominacion);
        this.empleador.set(empleador);
        this.desde.set(desde);
        this.hasta.set(hasta);
    }

    // Getter y setter para la propiedad 'desde'
    public LocalDate getDesde() {
        return desde.get();
    }

    public void setDesde(LocalDate desde) {
        this.desde.set(desde);
    }

    public ObjectProperty<LocalDate> desdeProperty() {
        return desde;
    }

    // Getter y setter para la propiedad 'hasta'
    public LocalDate getHasta() {
        return hasta.get();
    }

    public void setHasta(LocalDate hasta) {
        this.hasta.set(hasta);
    }

    public ObjectProperty<LocalDate> hastaProperty() {
        return hasta;
    }

    // Getter y setter para la propiedad 'denominacion'
    public String getDenominacion() {
        return denominacion.get();
    }

    public void setDenominacion(String denominacion) {
        this.denominacion.set(denominacion);
    }

    public void setEmpleador(String empleador) {
        this.empleador.set(empleador);
    }

    public StringProperty denominacionProperty() {
        return denominacion;
    }

    public String getEmpleador() {
        return empleador.get();
    }

    public StringProperty empleadorProperty() {
        return empleador;
    }


}
