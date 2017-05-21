package com.u.tallerify.networking;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

/**
 * Created by saguilera on 5/21/17.
 */
public class RestDeserializer
    implements TypeAdapterFactory {

    @Override
    public <T> TypeAdapter<T> create(Gson gson, final TypeToken<T> type) {

        final TypeAdapter<T> delegate = gson.getDelegateAdapter(this, type);
        final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);

        return new TypeAdapter<T>() {
            @Override
            public void write(JsonWriter out, T value) throws IOException {
                delegate.write(out, value);
            }

            @Override
            public T read(JsonReader in) throws IOException {
                JsonElement jsonElement = elementAdapter.read(in);

                if (jsonElement.isJsonObject()) {
                    JsonObject jsonObject = jsonElement.getAsJsonObject();
                    if (jsonObject.entrySet().size() == 2) {
                        jsonObject.remove("metadata");
                        jsonElement = jsonObject.entrySet().iterator().next().getValue();
                    }
                }
                return delegate.fromJsonTree(jsonElement);
            }
        }.nullSafe();
    }

}

