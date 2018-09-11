package pl.parkin9.xrest_project.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.parkin9.xrest_project.Exception.NumbersToSortingException;
import pl.parkin9.xrest_project.Exception.OrderException;
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
    public String pingPong() {

        return "pong";
    }

    // Endpoint 2.
    @PostMapping("/numbers/sort-command")
    public NumbersJson sortingNumbers(@RequestBody NumbersJson numbersJson) {

        if(numbersJson.getNumbers() == null
        || numbersJson.getNumbers().contains(null)
        || numbersJson.getNumbers().isEmpty()) {
            throw new NumbersToSortingException("Request doesn't contain any data to sorting.");

        } else if(numbersJson.getOrder() == null) {
            throw new OrderException("Sorting order is null");
        }

        return sortingService.sort(numbersJson);
    }
}