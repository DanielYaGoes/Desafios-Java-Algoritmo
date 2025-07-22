package Exercicio06.service.interfaces;

import Exercicio06.model.Item;
import Exercicio06.model.Order;

public interface OrderManager {

    void addItem(Order order, Item item);
}