package pl.parkin9.xrest_project.Serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.parkin9.xrest_project.Client.NBPApiClient;
import pl.parkin9.xrest_project.Exception.CurrencyCodeException;
import pl.parkin9.xrest_project.Model.CurrencyJson;
import pl.parkin9.xrest_project.Model.NBPApiJson;
import pl.parkin9.xrest_project.Model.Rate;

import java.io.IOException;

@Component
public class CurrencyJsonSerializer extends JsonSerializer<CurrencyJson> {

    private NBPApiClient nbpApiClient;

    @Autowired
    public CurrencyJsonSerializer(NBPApiClient nbpApiClient) {
        this.nbpApiClient = nbpApiClient;
    }

    public CurrencyJsonSerializer() {
    }

/////////////////////////////////////////////////////////////////////////////////

    @Override
    public void serialize(CurrencyJson currencyJson,
                          JsonGenerator jsonGenerator,
                          SerializerProvider serializerProvider) throws IOException {

        // Downloading NBPApiJson from NBPApiClient
        NBPApiJson nbpApiJson = nbpApiClient.getNBPApiJson();

        // Preparing currencyJson.currency (it's a currency code): trim + toUpperCase
        String currencyCode = currencyJson.getCurrency().trim().toUpperCase();


        jsonGenerator.writeStartObject();

        // In this loop, an exception will be thrown only
        // when the CurrencyCode isn't on the RatesList
        // and the whole list was checked.
        int counterLoop = 1;
        for(Rate rate : nbpApiJson.getRates()){

            if(currencyCode.equals(rate.getCode())) {
                jsonGenerator.writeNumberField("value", rate.getMid());
                break;

            } else if (counterLoop == nbpApiJson.getRates().size()){
                throw new CurrencyCodeException("Wrong currency code.");
            }

            counterLoop++;
        }

        jsonGenerator.writeEndObject();
    }


}
