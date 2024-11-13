/*package dad.micv.model.adapters;

import com.google.gson.*;

import java.io.*;
import java.nio.charset.*;
import java.nio.file.*;

public class CV {

    public void save(File file ){
        Files.writeString(file.toPath(),
                GSON.toJson(this),
                StandardCharsets.UTF_8
        );
    }

    public static CV load(File file) throws IOException {
        String json = Files.readString(file.toPath(), StandardCharsets.UTF_8);
        return GSON.fromJSON(json, CV.class);
    }
}*/
