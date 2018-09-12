package pl.parkin9.xrest_project.Serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.parkin9.xrest_project.Exception.CurrencyCodeException;
import pl.parkin9.xrest_project.Model.CurrencyJson;
import pl.parkin9.xrest_project.Model.NBPApiJson;
import pl.parkin9.xrest_project.Model.Rate;
import pl.parkin9.xrest_project.Service.NBPApiClientService;

import java.io.IOException;

@Component
public class CurrencyJsonSerializer extends JsonSerializer<CurrencyJson> {

    private NBPApiClientService nbpApiClientService;

    @Autowired
    public CurrencyJsonSerializer(NBPApiClientService nbpApiClientService) {
        this.nbpApiClientService = nbpApiClientService;
    }

    public CurrencyJsonSerializer() {
    }

/////////////////////////////////////////////////////////////////////////////////

    @Override
    public void serialize(CurrencyJson currencyJson,
                          JsonGenerator jsonGenerator,
                          SerializerProvider serializerProvider) throws IOException {

        NBPApiJson nbpApiJson = nbpApiClientService.getNBPApiJson();
        int counterLoop = 1;

        jsonGenerator.writeStartObject();

        // In this loop, an exception will be thrown only
        // when the CurrencyCode isn't on the RatesList
        // and the whole list was checked.
        for(Rate rate : nbpApiJson.getRates()){

            if(currencyJson.getCurrency().equals(rate.getCode())) {
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
