package pl.parkin9.xrest_project.Serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import pl.parkin9.xrest_project.Model.NumbersJson;

import java.io.IOException;


public class NumbersJsonSerializer extends JsonSerializer<NumbersJson> {

    @Override
    public void serialize(NumbersJson numbersJson,
                          JsonGenerator jsonGenerator,
                          SerializerProvider serializerProvider) throws IOException {

        jsonGenerator.writeStartObject();

        jsonGenerator.writeArrayFieldStart("numbers");
        for(Integer number : numbersJson.getNumbers()) {
            jsonGenerator.writeNumber(number);
        }
        jsonGenerator.writeEndArray();

        jsonGenerator.writeEndObject();
    }
}
