package pl.parkin9.xrest_project.Service;

import pl.parkin9.xrest_project.Model.CurrencyJson;

public interface PrepareCurrencyCodeService {

    CurrencyJson trimAndUpperCase(CurrencyJson currencyJson);
}
