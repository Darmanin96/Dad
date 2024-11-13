package dad.micv.model.adapters;

import javafx.beans.property.*;

public class Idioma extends Conocimiento{

    private  final StringProperty certificacion = new SimpleStringProperty();

    public Idioma(){

    }

    public Idioma(String certificacion, String denominacion){
        super(denominacion);
        this.certificacion.set(certificacion);
    }

    public String getCertificacion() {
        return certificacion.get();
    }

    public StringProperty certificacionProperty() {
        return certificacion;
    }

    public void setCertificacion(String certificacion) {
        this.certificacion.set(certificacion);
    }
}
