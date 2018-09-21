package pl.parkin9.xrest_project.Service;

import org.springframework.stereotype.Service;
import pl.parkin9.xrest_project.Model.NumbersJson;
import pl.parkin9.xrest_project.Model.OrderEnum;

import java.util.Collections;
import java.util.List;

@Service
public class SortingServiceImpl implements SortingService {

    public void sort(NumbersJson numbersJson) {

        List<Integer> numbersToSort = numbersJson.getNumbers();
        OrderEnum sortingOrder = numbersJson.getOrder();

        // Sorting ascending
        Collections.sort(numbersToSort);


        switch (sortingOrder) {

            case ASC:
                // Receiving already sorted numbers (ascending)
                break;

            case DESC:
                // Reversing the order of sorted numbers (descending)
                Collections.reverse(numbersToSort);
                break;
        }
    }
}
