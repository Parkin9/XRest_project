package pl.parkin9.xrest_project.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.parkin9.xrest_project.Exception.CurrencyCodeException;
import pl.parkin9.xrest_project.Exception.NumbersToSortingException;
import pl.parkin9.xrest_project.Exception.SortingOrderException;
import pl.parkin9.xrest_project.Model.CurrencyJson;
import pl.parkin9.xrest_project.Model.NumbersJson;
import pl.parkin9.xrest_project.Service.PrepareCurrencyCodeService;
import pl.parkin9.xrest_project.Service.SortingService;

@CrossOrigin
@RestController
public class IndexController {

    private final SortingService sortingService;
    private final PrepareCurrencyCodeService prepareCurrencyCodeService;

    @Autowired
    public IndexController(SortingService sortingService, PrepareCurrencyCodeService prepareCurrencyCodeService) {
        this.sortingService = sortingService;
        this.prepareCurrencyCodeService = prepareCurrencyCodeService;
    }

////////////////////////////////////////////////////////////////////////////

    // Endpoint 1.
    @GetMapping("/status/ping")
    public ResponseEntity<String> pingPong() {

        return new ResponseEntity<>("pong", HttpStatus.OK);
    }

    // Endpoint 2.
    @PostMapping("/numbers/sort-command")
    public ResponseEntity<NumbersJson> sortingNumbers(@RequestBody NumbersJson unsortedNumbersJson) {

        if(unsortedNumbersJson.getNumbers() == null
        || unsortedNumbersJson.getNumbers().contains(null)
        || unsortedNumbersJson.getNumbers().isEmpty()) {
            throw new NumbersToSortingException("Request doesn't contain any data to sort.");

        } else if(unsortedNumbersJson.getOrder() == null) {
            throw new SortingOrderException("Sorting order is null");
        }

        // Sorting service
        NumbersJson sortedNumbersJson = sortingService.sort(unsortedNumbersJson);

        return new ResponseEntity<>(sortedNumbersJson, HttpStatus.OK);
    }

    // Endpoint 3.
    @PostMapping("/currencies/get-current-currency-value-command")
    public ResponseEntity<CurrencyJson> getCurrencyValue(@RequestBody CurrencyJson currencyJson) {

        try {
            // Preparing CurrencyJson.currency: trim + toUpperCase
            CurrencyJson matchedToClientApiCurrencyJson = prepareCurrencyCodeService.trimAndUpperCase(currencyJson);

            return new ResponseEntity<>(matchedToClientApiCurrencyJson, HttpStatus.OK);

        // If (@RequestBody) currencyJson is a null.
        } catch (NullPointerException e) {

            throw new CurrencyCodeException("Currency code is a null.");
        }
    }
}