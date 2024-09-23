package dad.bindings.observer;

public class StringObservable extends Observable<String> {

    private String value;

    @Override
    public void setValue(String value) {
        super.setValue(value);
        this.value = value;
    }

}

