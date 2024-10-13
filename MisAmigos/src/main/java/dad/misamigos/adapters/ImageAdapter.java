package dad.misamigos.adapters;

import com.google.gson.*;
import com.google.gson.stream.*;
import dad.misamigos.utils.*;
import javafx.scene.image.*;

import java.io.*;

public class ImageAdapter extends TypeAdapter<Image> {
    @Override
    public void write(JsonWriter out, Image value) throws IOException {
        if (value == null) {
            out.nullValue();
        }else {
            out.value(ImageUtils.encodeImage(value));
        }
    }

    @Override
    public Image read(JsonReader in) throws IOException {
        if (in.peek() == JsonToken.NULL) {
            in.nextNull();
            return null;
        }
        return ImageUtils.decodeImage(in.nextString());
    }
}
