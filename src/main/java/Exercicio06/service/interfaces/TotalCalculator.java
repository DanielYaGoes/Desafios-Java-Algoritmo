package Exercicio06.service.interfaces;

import Exercicio06.model.Item;

import java.util.List;

public interface TotalCalculator {

    double calculateTotal(List<Item> items);
}
