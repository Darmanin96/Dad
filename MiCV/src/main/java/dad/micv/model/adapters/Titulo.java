package dad.micv.model.adapters;

import javafx.beans.property.*;

import java.time.*;

public class Titulo {

    private final ObjectProperty<LocalDate> desde = new SimpleObjectProperty<>();
    private final ObjectProperty<LocalDate> hasta = new SimpleObjectProperty<>();
    private final StringProperty denominacion = new SimpleStringProperty();
    private final StringProperty organizador = new SimpleStringProperty();

    // Constructor vacío
    public Titulo() {
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

    public StringProperty denominacionProperty() {
        return denominacion;
    }

    // Getter y setter para la propiedad 'organizador'
    public String getOrganizador() {
        return organizador.get();
    }

    public void setOrganizador(String organizador) {
        this.organizador.set(organizador);
    }

    public StringProperty organizadorProperty() {
        return organizador;
    }
}
