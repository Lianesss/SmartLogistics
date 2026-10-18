package cargo;

import interfaces.ICargo;

import java.util.ArrayList;
import java.util.List;

public class Warehouse<T extends ICargo> {
    private List<T> items = new ArrayList<>();

    public void addItem(T item) {
        items.add(item);
    }

    public double getTotalWeight() {
        double sum = 0;
        for (T item : items) {
            sum += item.getWeight();  // благодаря extends ICargo
        }
        return sum;
    }

    public void printManifest() {
        for (T item : items) {
            System.out.println(item.getType() + " — " + item.getWeight() + " кг");
        }
    }
}

