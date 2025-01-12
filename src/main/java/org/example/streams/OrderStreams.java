package org.example.streams;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class OrderStreams {
    public static void main(String[] args) {
        Itemz item1 = new Itemz(777, 5, 100);
        Itemz item2 = new Itemz(888, 4, 200);
        Itemz item3 = new Itemz(999, 2, 100);
        Order o1 = new Order(11, 101, "1/1/24", List.of(item1, item3), 700);
        Order o2 = new Order(12, 102, "1/2/24", List.of(item2, item3), 1000);
        Order o3 = new Order(13, 103, "1/3/24", List.of(item3), 200);

        List<Order> orders = List.of(o1, o2, o3);
        orders.stream().collect(Collectors.groupingBy(Order::getCustomerId, Collectors.counting())).entrySet().forEach(System.out::println);

        orders.stream().flatMap(o -> o.getItems().stream()).collect(Collectors.groupingBy(Itemz::getItemId, Collectors.summingInt(Itemz::getQuantity))).entrySet().forEach(System.out::println);

        IntStream
                .range(0,5)
                .map(i -> i%2)
                .distinct()
                .limit(2)
                .forEach(System.out::println);

    }

}

class Order {
    int orderId;
    int customerId;
    String orderDate;
    List<Itemz> items;
    double total;

    public Order(int orderId, int customerId, String orderDate, List<Itemz> items, double total) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.orderDate = orderDate;
        this.items = items;
        this.total = total;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", customerId=" + customerId +
                ", orderDate='" + orderDate + '\'' +
                ", items=" + items +
                ", total=" + total +
                '}';
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public List<Itemz> getItems() {
        return items;
    }

    public void setItems(List<Itemz> items) {
        this.items = items;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}

class Itemz {
    int itemId;
    int quantity;
    double pricePerUnit;

    public Itemz(int itemId, int quantity, double pricePerUnit) {
        this.itemId = itemId;
        this.quantity = quantity;
        this.pricePerUnit = pricePerUnit;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPricePerUnit() {
        return pricePerUnit;
    }

    public void setPricePerUnit(double pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }

    @Override
    public String toString() {
        return "Itemz{" +
                "itemId=" + itemId +
                ", quantity=" + quantity +
                ", pricePerUnit=" + pricePerUnit +
                '}';
    }
}
