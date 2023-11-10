package com.laba.solvd.HW_ShoppingMallApp.Checkout;

public abstract class AbstractItem {
    protected String id;
    protected String name;

    public AbstractItem(String id, String name) {
        this.id = id;
        this.name = name;
    }

    // Abstract methods
    public abstract double getPrice();
    public abstract void applyDiscount(double discountRate);

    // toString(), hashCode(), and equals() methods
    @Override
    public String toString() {
        return "Item{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        // Simplified hash code example
        return id.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        AbstractItem item = (AbstractItem) obj;
        return id.equals(item.id);
    }
}
