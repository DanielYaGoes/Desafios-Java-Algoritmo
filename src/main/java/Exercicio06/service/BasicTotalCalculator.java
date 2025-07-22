package Exercicio06.service;

import Exercicio06.model.Item;
import Exercicio06.service.interfaces.TotalCalculator;

import java.util.List;

public class BasicTotalCalculator implements TotalCalculator {
    @Override
    public double calculateTotal(List<Item> items) {
        return items.stream()
                .mapToDouble(Item::getPrice)
                .sum();
    }
}
