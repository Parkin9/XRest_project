package pl.parkin9.xrest_project.Model;

import java.util.ArrayList;
import java.util.List;

public class NumbersJson {

    private List<Integer> numbers = new ArrayList<>();
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
