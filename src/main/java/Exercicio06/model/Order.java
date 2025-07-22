package Exercicio06.model;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<Item> items;

    public Order() {
        this.items = new ArrayList<>();
    }

    public List<Item> getItems() {
        return items;
    }
}
