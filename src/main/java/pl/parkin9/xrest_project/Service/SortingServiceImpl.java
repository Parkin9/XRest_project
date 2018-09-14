package pl.parkin9.xrest_project.Service;

import org.springframework.stereotype.Service;
import pl.parkin9.xrest_project.Exception.SortingOrderException;
import pl.parkin9.xrest_project.Model.NumbersJson;

import java.util.Collections;
import java.util.List;

@Service
public class SortingServiceImpl implements SortingService {

    public NumbersJson sort(NumbersJson numbersJson) {

        List<Integer> numbersToSort = numbersJson.getNumbers();

        // Preparing numberJson.order: trim + toUpperCase
        String orderSorting = numbersJson.getOrder().toUpperCase().trim();

        // Sorting ascending
        Collections.sort(numbersToSort);

        switch (orderSorting) {
            case "ASC":

                // Receiving already sorted numbers (ascending)
                return numbersJson;

            case "DESC":

                // Reversing the order of sorted numbers (descending)
                Collections.reverse(numbersToSort);
                return numbersJson;

            default:
                throw new SortingOrderException("Wrong sorting order");
        }
    }
}
