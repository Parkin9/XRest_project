package pl.parkin9.xrest_project.Service;

import org.springframework.stereotype.Service;
import pl.parkin9.xrest_project.Exception.OrderException;
import pl.parkin9.xrest_project.Model.NumbersJson;

import java.util.Collections;
import java.util.List;

@Service
public class SortingService {

    public NumbersJson sort(NumbersJson numbersJson) {

        List<Integer> numbersToSort = numbersJson.getNumbers();

        // numberJson.order: trim + toLowerCase
        String order = numbersJson.getOrder().toLowerCase().trim();


        // Sorting ascending
        Collections.sort(numbersToSort);

        switch (order) {
            case "asc":

                // Receiving already sorted numbers (ascending)
                return numbersJson;

            case "desc":

                // Reversing the order of sorted numbers (descending)
                Collections.reverse(numbersToSort);
                return numbersJson;

            default:
                throw new OrderException("Wrong sorting order");
        }
    }
}
