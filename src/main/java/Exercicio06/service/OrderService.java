package Exercicio06.service;

import Exercicio06.model.Item;
import Exercicio06.model.Order;
import Exercicio06.service.interfaces.OrderManager;

public class OrderService implements OrderManager {

    @Override
    public void addItem(Order order, Item item) {
        order.getItems().add(item);
    }
}