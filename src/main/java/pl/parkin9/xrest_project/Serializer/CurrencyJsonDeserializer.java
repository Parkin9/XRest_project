package pl.parkin9.xrest_project.Serializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import pl.parkin9.xrest_project.Model.CurrencyJson;

import java.io.IOException;

/*
* I wrote this class because Jackson has problem with a mapping request, witch contains null.
* I don't know why. Now, the library has calm down :)
* Here, a null is turn into "null" (String) and it helped with a mapping,
* but the class itself is no longer necessary.
* I have left it to show that I know how to write the deserializer.
* Quite similar to the serializer ;)
*/

public class CurrencyJsonDeserializer extends JsonDeserializer<CurrencyJson> {

    @Override
    public CurrencyJson deserialize(JsonParser jsonParser,
                                    DeserializationContext deserializationContext) throws IOException {

        JsonNode node = jsonParser.getCodec().readTree(jsonParser);
        String currencyCode = node.get("currency").asText();

        CurrencyJson currencyJson = new CurrencyJson();
        currencyJson.setCurrency(currencyCode);

        return currencyJson;
    }
}
