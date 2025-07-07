// package FruitServiceEngine.server.src.server.tasks;

package server.tasks;

public class CalculateCost implements Task<String> {
    private final double totalCost;
    private final double amountGiven;
    private final String cashier;

    public CalculateCost(double totalCost, double amountGiven, String cashier) {
        this.totalCost = totalCost;
        this.amountGiven = amountGiven;
        this.cashier = cashier;
    }

    public String execute() {
        double change = amountGiven - totalCost;
        return "Receipt:\n" +
               "- Total Cost: KES " + totalCost + "\n" +
               "- Amount Paid: KES " + amountGiven + "\n" +
               "- Change: KES " + change + "\n" +
               "- Cashier: " + cashier;
    }
}
