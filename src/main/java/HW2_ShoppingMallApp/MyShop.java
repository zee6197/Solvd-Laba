public class MyShop {
    private String shopName;
    private Inventory inventory; // Composition example

    public MyShop(String shopName) {
        this.shopName = shopName;
        this.inventory = new Inventory(); // Connecting classes in a hierarchy
    }

    // Getters and Setters
    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public Inventory getInventory() {
        return inventory;
    }

    // A method with logic
    public void restockInventory(Product product, int quantity) {
        inventory.addProduct(product, quantity);
    }

    // Overloaded methods
    public void openShop() {
        System.out.println(shopName + " is now open.");
    }
    public void openShop(String managerName) {
        System.out.println(shopName + " is now open, managed by " + managerName + ".");
    }
}