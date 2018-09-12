package pl.parkin9.xrest_project.Model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import pl.parkin9.xrest_project.Serializer.NumbersJsonSerializer;

import java.io.Serializable;
import java.util.List;

@JsonSerialize(using = NumbersJsonSerializer.class)
public class NumbersJson implements Serializable {

    private List<Integer> numbers;
    private String order;

//////////////////////////////////////////////////////////////////////

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void setNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "NumbersJson{" +
                "numbers=" + numbers +
                ", order='" + order + '\'' +
                '}';
    }
}
