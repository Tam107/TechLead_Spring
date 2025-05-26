package com.techlead.service.core1.helper;

public class Item {
    private int id;
    private int order;

    public Item(int id, int order) {
        this.id = id;
        this.order = order;
    }

    public int getId() {
        return id;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "{id: " + id + ", order: " + order + "}";
    }
}
