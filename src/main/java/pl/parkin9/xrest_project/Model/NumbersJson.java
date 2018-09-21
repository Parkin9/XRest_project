package pl.parkin9.xrest_project.Model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import pl.parkin9.xrest_project.Exception.SortingOrderException;
import pl.parkin9.xrest_project.Serializer.NumbersJsonSerializer;

import java.io.Serializable;
import java.util.List;

@JsonSerialize(using = NumbersJsonSerializer.class)
public class NumbersJson implements Serializable {

    private List<Integer> numbers;
    private OrderEnum order;

//////////////////////////////////////////////////////////////////////

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void setNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public OrderEnum getOrder() {
        return order;
    }

    public void setOrder(String order) {

        try {
            String preparedOrder = order.toUpperCase().trim();
            this.order = OrderEnum.valueOf(preparedOrder);

        } catch (IllegalArgumentException ex) {
            throw new SortingOrderException("Wrong sorting order");
        }
    }

    @Override
    public String toString() {
        return "NumbersJson{" +
                "numbers=" + numbers +
                ", order='" + order + '\'' +
                '}';
    }
}
