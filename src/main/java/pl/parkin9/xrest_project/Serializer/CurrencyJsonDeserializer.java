package pl.parkin9.xrest_project.Serializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import pl.parkin9.xrest_project.Model.CurrencyJson;

import java.io.IOException;

/*
* TODO: describe class
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
