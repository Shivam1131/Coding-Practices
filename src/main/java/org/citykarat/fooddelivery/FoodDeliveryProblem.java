package org.citykarat.fooddelivery;

import java.util.*;
import java.util.stream.Collectors;

enum OrderStatus {
    PLACED,
    PREPARING,
    OUT_FOR_DELIVERY,
    DELIVERED,
    CANCELED
}

class Order {
    int orderId;
    int restaurantId;
    int customerId;
    double orderValue;
    double distanceKm;
    OrderStatus status;

    Order(int orderId, int restaurantId, int customerId, double orderValue, double distanceKm, OrderStatus status) {
        this.orderId = orderId;
        this.restaurantId = restaurantId;
        this.customerId = customerId;
        this.orderValue = orderValue;
        this.distanceKm = distanceKm;
        this.status = status;
    }
}

class Delivery {
    int deliveryId;
    int startMinute;
    int endMinute;

    Delivery(int deliveryId, int startMinute, int endMinute) {
        this.deliveryId = deliveryId;
        this.startMinute = startMinute;
        this.endMinute = endMinute;
    }

    int getDurationMinutes() {
        return endMinute - startMinute;
    }
}

class OrderStats {
    int totalOrders;
    int activeOrders;
    int closedOrders;

    OrderStats(int totalOrders, int activeOrders, int closedOrders) {
        this.totalOrders = totalOrders;
        this.activeOrders = activeOrders;
        this.closedOrders = closedOrders;
    }
}

public class FoodDeliveryProblem {
    public static List<Order> sampleOrders() {
        return Arrays.asList(
                new Order(1, 100, 501, 25.0, 3.2, OrderStatus.PLACED),
                new Order(2, 100, 502, 40.0, 5.0, OrderStatus.DELIVERED),
                new Order(3, 200, 503, 18.5, 2.1, OrderStatus.CANCELED),
                new Order(4, 200, 504, 30.0, 4.5, OrderStatus.OUT_FOR_DELIVERY)
        );
    }
    public static Map<Integer, List<Delivery>> sampleDeliveriesByOrder() {
        Map<Integer, List<Delivery>> deliveries = new HashMap<>();
        deliveries.put(2, new ArrayList<>(Arrays.asList(new Delivery(11, 100, 135))));
        deliveries.put(
                4, new ArrayList<>(Arrays.asList(
                        new Delivery(12, 200, 250),
                        new Delivery(13, 260, 300)
                )));
        return deliveries;
    }

    // TODO 1: Return order statistics.
    // Active: PLACED, PREPARING, OUT_FOR_DELIVERY.
    // Closed: DELIVERED, CANCELED.
    public OrderStats getOrderStats() {
        int totalOrdersCount = orders.size();
        int closedOrderCount = (int) orders.stream().filter(o -> o.status ==  OrderStatus.DELIVERED || o.status == OrderStatus.CANCELED).count();
        int activeOrderCount = totalOrdersCount - closedOrderCount;
        return new OrderStats(totalOrdersCount, activeOrderCount, closedOrderCount);
        //throw new UnsupportedOperationException("Implement this");
    }

    // TODO 2: Associate delivery with order.
    // If order does not exist, ignore it.
    public void addDelivery(int orderId, Delivery delivery) {
        if(orders.stream().anyMatch(e->e.orderId == orderId)){
            if(deliveriesByOrder.containsKey(orderId)) {
                deliveriesByOrder.get(orderId).add(delivery);
            } else {
                ArrayList<Delivery> deliveries = new ArrayList<>();
                deliveries.add(delivery);
                deliveriesByOrder.put(orderId, deliveries);
            }
        }
        //throw new UnsupportedOperationException("Implement this");
    }

    // group orders by restaurant id,
    // each order in the list get deliveries and then calculate delivery minutes and then calculate average for those minutes

    // TODO 3: Average delivery duration by restaurant.
    // Count all deliveries for all orders of that restaurant.
    public Map<Integer, Double> getAverageDeliveryTimeByRestaurant() {

        Map<Integer, Double> averageDeliveryMapForRestaurant = new HashMap<>();

        Map<Integer, List<Order>> restaurantOrdersMap = orders.stream()
                .collect(Collectors.groupingBy(o -> o.restaurantId));

        for (Integer restaurantId : restaurantOrdersMap.keySet()) {

            List<Integer> deliveryDurations = new ArrayList<>();

            restaurantOrdersMap.get(restaurantId).forEach(order -> {
                if (deliveriesByOrder.containsKey(order.orderId)) {
                    deliveriesByOrder.get(order.orderId).forEach(delivery -> {
                        deliveryDurations.add(delivery.getDurationMinutes());
                    });
                }
            });

            double average = deliveryDurations.stream()
                    .mapToInt(e -> e)
                    .average()
                    .orElse(0.0);

            averageDeliveryMapForRestaurant.put(restaurantId, average);
        }

        return averageDeliveryMapForRestaurant;
    }

    List<Order> orders = new ArrayList<>(sampleOrders());
    Map<Integer, List<Delivery>> deliveriesByOrder = sampleDeliveriesByOrder();
}

