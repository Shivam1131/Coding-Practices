package org.citykarat.stockprices;

import java.util.*;

class Stock {
    String symbol;
    String name;

    Stock(String symbol, String name) {
        this.symbol = symbol;
        this.name = name;
    }
}

class PriceRecord {
    Stock stock;
    int price;
    String date;

    PriceRecord(Stock stock, int price, String date) {
        this.stock = stock;
        this.price = price;
        this.date = date;
    }
}

class StockUpdate {
    int timestamp;
    int price;

    StockUpdate(int timestamp, int price) {
        this.timestamp = timestamp;
        this.price = price;
    }
}

public class StockPriceProblem {
    static Stock sampleStock = new Stock("CITI", "Citigroup");

    public static List<PriceRecord> samplePriceRecords() {
        return Arrays.asList(
                new PriceRecord(sampleStock, 110, "2023-06-29"),
                new PriceRecord(sampleStock, 112, "2023-07-01"),
                new PriceRecord(sampleStock, 90, "2023-06-25"),
                new PriceRecord(sampleStock, 105, "2023-07-06")
        );
    }

    public static List<StockUpdate> sampleStreamUpdates() {
        return Arrays.asList(
                new StockUpdate(1, 10),
                new StockUpdate(2, 5),
                new StockUpdate(1, 3),
                new StockUpdate(4, 2)
        );
    }

    // TODO 1: Return max price from priceRecords.
    public int getMaxPrice() {
        return priceRecords.stream().mapToInt(records-> records.price).max().orElse(0);
        //throw new UnsupportedOperationException("Implement this");
    }

    // TODO 2: Return min price from priceRecords.
    public int getMinPrice() {
        return priceRecords.stream().mapToInt(records-> records.price).min().orElse(0);
        // throw new UnsupportedOperationException("Implement this");
    }

    // TODO 3: Return average price from priceRecords.
    public double getAveragePrice() {
        return priceRecords.stream().mapToInt(records-> records.price).average().orElse(0);
        //throw new UnsupportedOperationException("Implement this");
    }

    // TODO 4: Sort by date, then find biggest consecutive increase.
    // Raw sorted prices:
    // 2023-06-25 -> 90
    // 2023-06-29 -> 110, change +20
    // 2023-07-01 -> 112, change +2
    // 2023-07-06 -> 105, change -7
    // Expected result idea: [20, "2023-06-25", "2023-06-29"]
    public Object[] getBiggestChange() {

        List<PriceRecord> sortedRecords = new ArrayList<>(priceRecords);

        sortedRecords.sort(Comparator.comparing(record -> record.date));

        int biggestChange = Integer.MIN_VALUE;
        String startDate = "";
        String endDate = "";

        for (int i = 1; i < sortedRecords.size(); i++) {
            PriceRecord previous = sortedRecords.get(i - 1);
            PriceRecord current = sortedRecords.get(i);

            int change = current.price - previous.price;

            if (change > biggestChange) {
                biggestChange = change;
                startDate = previous.date;
                endDate = current.date;
            }
        }

        return new Object[]{biggestChange, startDate, endDate};
    }
    // TODO 5: Design data structure for stock stream.
    // update(timestamp, price), current(), maximum(), minimum()
    // Important: same timestamp can be corrected with a new price.
    public void update(int timestamp, int price) {
            pricesByTimestamp.put(timestamp, price);
    }

    public int current() {
        if (pricesByTimestamp.isEmpty()) {
            return -1;
        }
        int max = pricesByTimestamp.keySet().stream().mapToInt(timestamp->timestamp).max().getAsInt();
        return pricesByTimestamp.get(max);
        //throw new UnsupportedOperationException("Implement this");
    }

    public int maximum() {
        if (pricesByTimestamp.isEmpty()) {
            return -1;
        }
        return pricesByTimestamp.values()
                .stream()
                .mapToInt(price -> price)
                .max()
                .getAsInt();
    }

    public int minimum() {
        if (pricesByTimestamp.isEmpty()) {
            return -1;
        }
        return pricesByTimestamp.values()
                .stream()
                .mapToInt(price -> price)
                .min()
                .getAsInt();
    }

    List<PriceRecord> priceRecords = new ArrayList<>(samplePriceRecords());
    Map<Integer, Integer> pricesByTimestamp = new HashMap<>();
}
