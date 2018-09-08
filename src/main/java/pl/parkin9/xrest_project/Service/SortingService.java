package pl.parkin9.xrest_project.Service;

import org.springframework.stereotype.Service;
import pl.parkin9.xrest_project.Model.NumbersJson;

import java.util.Collections;
import java.util.List;

@Service
public class SortingService {

    // TODO add Exception (order: null or another value that ASC/DESC)
    public NumbersJson sort(NumbersJson numbersJson) {

        List<Integer> numbersToSorting = numbersJson.getNumbers();
        String order = numbersJson.getOrder();

        Collections.sort(numbersToSorting);


        if(order.equals("ASC")) {

            return numbersJson;

        } else /*if (order.equals("DESC"))*/ {

            Collections.reverse(numbersToSorting);

            return numbersJson;
        }

    }
}
