package server.utils;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class FruitPriceTable {
    private static final Map<String, Double> table = new ConcurrentHashMap<>();

    public static void add(String fruit, double price) {
        table.put(fruit, price);
    }

    public static boolean update(String fruit, double price) {
        return table.replace(fruit, price) != null;
    }

    public static boolean delete(String fruit) {
        return table.remove(fruit) != null;
    }

    public static Double getPrice(String fruit) {
        return table.get(fruit);
    }

    public static Map<String, Double> getAll() {
        return table;
    }
}

