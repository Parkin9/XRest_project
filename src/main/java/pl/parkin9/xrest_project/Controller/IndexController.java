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
import pl.parkin9.xrest_project.Service.SortingService;

@CrossOrigin
@RestController
public class IndexController {

    private final SortingService sortingService;

    @Autowired
    public IndexController(SortingService sortingService) {
        this.sortingService = sortingService;
    }

////////////////////////////////////////////////////////////////////////////

    // Endpoint 1.
    @GetMapping("/status/ping")
    public ResponseEntity<String> pingPong() {

        return new ResponseEntity<>("pong", HttpStatus.OK);
    }


    // Endpoint 2.
    @PostMapping(value = "/numbers/sort-command", consumes = "application/json;charset=UTF-8",
                                                    produces = "application/json;charset=UTF-8")
    public ResponseEntity<NumbersJson> sortingNumbers(@RequestBody NumbersJson numbersJson) {

        // Looking for trouble :) (nulls for example)
        if(numbersJson.getNumbers() == null
        || numbersJson.getNumbers().contains(null)
        || numbersJson.getNumbers().isEmpty()) {
            throw new NumbersToSortingException("Request doesn't contain any data to sort.");

        } else if(numbersJson.getOrder() == null) {
            throw new SortingOrderException("Sorting order is null");
        }


        // Sorting numbers
        sortingService.sort(numbersJson);


        return new ResponseEntity<>(numbersJson, HttpStatus.OK);
    }


    // Endpoint 3.
    @PostMapping(value = "/currencies/get-current-currency-value-command", consumes = "application/json;charset=UTF-8",
                                                                            produces = "application/json;charset=UTF-8")
    public ResponseEntity<CurrencyJson> getCurrencyValue(@RequestBody CurrencyJson currencyJson) {

        // Looking for null
        if(currencyJson.getCurrency() == null) {
            throw new CurrencyCodeException("Wrong currency code.");
        }


        return new ResponseEntity<>(currencyJson, HttpStatus.OK);
    }
}