// package FruitServiceEngine.server.src.server.tasks;

package server.tasks;

import server.utils.FruitPriceTable;

public class AddFruitPrice implements Task<String> {
    private final String fruit;
    private final double price;

    public AddFruitPrice(String fruit, double price) {
        this.fruit = fruit;
        this.price = price;
    }

    public String execute() {
        FruitPriceTable.add(fruit, price);
        return fruit + " added at price KES " + price;
    }
}
