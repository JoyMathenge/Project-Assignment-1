// package FruitServiceEngine.server.src.server.tasks;

package server.tasks;

import server.utils.FruitPriceTable;

public class DeleteFruitPrice implements Task<String> {
    private final String fruit;

    public DeleteFruitPrice(String fruit) {
        this.fruit = fruit;
    }

    public String execute() {
        boolean removed = FruitPriceTable.delete(fruit);
        return removed ? fruit + " deleted." : fruit + " not found.";
    }
}
