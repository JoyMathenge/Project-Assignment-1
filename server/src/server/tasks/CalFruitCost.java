// package FruitServiceEngine.server.src.server.tasks;

package server.tasks;

import server.utils.FruitPriceTable;

public class CalFruitCost implements Task<String> {
    private final String fruit;
    private final int quantity;

    public CalFruitCost(String fruit, int quantity) {
        this.fruit = fruit;
        this.quantity = quantity;
    }

    public String execute() {
        Double price = FruitPriceTable.getPrice(fruit);
        if (price == null) return "Error: Fruit not found.";
        return "Cost of " + quantity + " " + fruit + "(s): KES " + (price * quantity);
    }
}
