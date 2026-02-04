import java.util.*;

public class ShoppingCartApp {

    // Product Class
    static class Product {
        private int id;
        private String name;
        private double price;

        public Product(int id, String name, double price) {
            this.id = id;
            this.name = name;
            this.price = price;
        }

        public int getId() { return id; }
        public String getName() { return name; }
        public double getPrice() { return price; }

        @Override
        public String toString() {
            return id + ". " + name + " - ₹" + price;
        }
    }

    // CartItem Class
    static class CartItem {
        private Product product;
        private int quantity;

        public CartItem(Product product, int quantity) {
            this.product = product;
            this.quantity = quantity;
        }

        public double getTotalPrice() {
            return product.getPrice() * quantity;
        }

        public Product getProduct() { return product; }
        public int getQuantity() { return quantity; }

        @Override
        public String toString() {
            return product.getName() + " x" + quantity + " = ₹" + getTotalPrice();
        }
    }

    // ShoppingCart Class
    static class ShoppingCart {
        private List<CartItem> items = new ArrayList<>();

        public void addToCart(Product product, int quantity) {
            for (CartItem item : items) {
                if (item.getProduct().getId() == product.getId()) {
                    items.set(items.indexOf(item), new CartItem(product, item.getQuantity() + quantity));
                    return;
                }
            }
            items.add(new CartItem(product, quantity));
        }

        public void removeFromCart(int productId) {
            items.removeIf(item -> item.getProduct().getId() == productId);
        }

        public void viewCart() {
            if (items.isEmpty()) {
                System.out.println("Your cart is empty.");
                return;
            }

            System.out.println("\nYour Shopping Cart:");
            for (CartItem item : items) {
                System.out.println(item);
            }
            System.out.println("Total: ₹" + getTotalPrice() + "\n");
        }

        public double getTotalPrice() {
            return items.stream().mapToDouble(CartItem::getTotalPrice).sum();
        }

        public void checkout() {
            viewCart();
            System.out.println("Thank you for your purchase!\n");
            items.clear();
        }
    }

    // Main Method
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Product> products = List.of(
            new Product(1, "Laptop", 50000),
            new Product(2, "Smartphone", 20000),
            new Product(3, "Headphones", 1500)
        );

        ShoppingCart cart = new ShoppingCart();

        while (true) {
            System.out.println("\n--- Welcome to the E-Shop ---");
            System.out.println("Available Products:");
            for (Product p : products) {
                System.out.println(p);
            }

            System.out.println("\n1. Add to Cart");
            System.out.println("2. Remove from Cart");
            System.out.println("3. View Cart");
            System.out.println("4. Checkout");
            System.out.println("5. Exit");

            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Product ID: ");
                    int id = scanner.nextInt();
                    System.out.print("Enter Quantity: ");
                    int qty = scanner.nextInt();
                    products.stream()
                        .filter(p -> p.getId() == id)
                        .findFirst()
                        .ifPresentOrElse(
                            p -> cart.addToCart(p, qty),
                            () -> System.out.println("Product not found.")
                        );
                    break;

                case 2:
                    System.out.print("Enter Product ID to remove: ");
                    int removeId = scanner.nextInt();
                    cart.removeFromCart(removeId);
                    break;

                case 3:
                    cart.viewCart();
                    break;

                case 4:
                    cart.checkout();
                    break;

                case 5:
                    System.out.println("Exiting... Goodbye!");
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}