package pl.parkin9.xrest_project.Model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import pl.parkin9.xrest_project.Serializer.CurrencyJsonSerializer;

import java.io.Serializable;

@JsonSerialize(using = CurrencyJsonSerializer.class)
//@JsonDeserialize(using = CurrencyJsonDeserializer.class)
public class CurrencyJson implements Serializable {

    private String currency;

///////////////////////////////////////////////////////////////

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "CurrencyJson{" +
                "currency='" + currency + '\'' +
                '}';
    }
}
