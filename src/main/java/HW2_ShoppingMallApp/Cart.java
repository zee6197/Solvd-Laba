

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<CartItem> cartItems;

    public Cart() {
        this.cartItems = new ArrayList<>();
    }

    public void addCartItem(CartItem item) {
        this.cartItems.add(item);
    }

    public List<CartItem> getCartItems() {
        return this.cartItems;
    }

    public double calculateTotal() {
        return cartItems.stream()
                .mapToDouble(item -> item.getProduct().getPrice() * item.getQuantity())
                .sum();
    }
}
