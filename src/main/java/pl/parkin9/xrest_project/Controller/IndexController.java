package pl.parkin9.xrest_project.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.parkin9.xrest_project.Model.NumbersJson;
import pl.parkin9.xrest_project.Service.SortingService;

@RestController
public class IndexController {

    private final SortingService sortingService;
    //private final ObjectMapper objectMapper;

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

        // TODO add a try/catch block
        return sortingService.sort(numbersJson);
    }
}