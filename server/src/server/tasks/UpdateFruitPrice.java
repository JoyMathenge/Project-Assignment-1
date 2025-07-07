// package FruitServiceEngine.server.src.server.tasks;

package server.tasks;

import server.utils.FruitPriceTable;

public class UpdateFruitPrice implements Task<String> {
    private final String fruit;
    private final double price;

    public UpdateFruitPrice(String fruit, double price) {
        this.fruit = fruit;
        this.price = price;
    }

    public String execute() {
        boolean updated = FruitPriceTable.update(fruit, price);
        return updated ? fruit + " updated to KES " + price : fruit + " not found.";
    }
}
