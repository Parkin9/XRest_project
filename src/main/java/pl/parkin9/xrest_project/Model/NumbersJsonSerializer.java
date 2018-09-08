package pl.parkin9.xrest_project.Model;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.springframework.boot.jackson.JsonComponent;

import java.io.IOException;

@JsonComponent
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
