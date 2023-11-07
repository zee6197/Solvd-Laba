public class Product {
    private String name;
    private double price;

    // Constructor that initializes a Product with a name and price
    public Product(String name, String bread, double price) {
        this.name = name;
        this.price = price;
    }

    // Getter for the name
    public String getName() {
        return name;
    }

    // Setter for the name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for the price
    public double getPrice() {
        return price;
    }

    // Setter for the price
    public void setPrice(double price) {
        this.price = price;
    }
}
