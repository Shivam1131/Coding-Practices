package org.citykarat_new.tradereconciliation;

import java.util.Objects;

public class Trade {

    private final String symbol;
    private final String side;
    private final int quantity;
    private final double price;

    public Trade(String symbol, String side, int quantity, double price) {
        this.symbol = symbol;
        this.side = side;
        this.quantity = quantity;
        this.price = price;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getSide() {
        return side;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    /*
     * TASK 1:
     * The supplied tests expose a bug in equality behavior.
     * Find the problem and correct equals/hashCode so a Trade represents
     * the complete business identity required by the tests.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Trade)) return false;
        Trade trade = (Trade) o;

        // Existing implementation. Do not assume it is correct.
        return Objects.equals(symbol, trade.symbol);
    }

    @Override
    public int hashCode() {
        // Existing implementation. Do not assume it is correct.
        return Objects.hash(symbol);
    }

    @Override
    public String toString() {
        return "Trade{" +
                "symbol='" + symbol + '\'' +
                ", side='" + side + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}
