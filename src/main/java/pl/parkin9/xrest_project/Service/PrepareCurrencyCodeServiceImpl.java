package pl.parkin9.xrest_project.Service;

import org.springframework.stereotype.Service;
import pl.parkin9.xrest_project.Model.CurrencyJson;

@Service
public class PrepareCurrencyCodeServiceImpl implements PrepareCurrencyCodeService {

    public CurrencyJson trimAndUpperCase(CurrencyJson currencyJson) {

        String currencyStr = currencyJson.getCurrency();
        currencyJson.setCurrency(currencyStr.trim().toUpperCase());

        return currencyJson;
    }
}
