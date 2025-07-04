import model.Cart;
import model.Customer;
import model.product.Product;
import model.product.ShippableExpirableProduct;
import model.product.ShippableProducts;

import java.time.LocalDate;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        try {
            Cart cart = new Cart();
            Customer customer = new Customer("Karimelnekheily", 4000, cart);

            //As cheese are expirable and shippable
            ShippableExpirableProduct cheese = new ShippableExpirableProduct("Cheese", 70, 10, 0.4, LocalDate.of(2025, 7, 27));
            //Tv shippable but not expired
            ShippableProducts tv = new ShippableProducts("TV", 1200, 20, 0.7);
            //scratch card not expired and not shippable
            Product scratchCard = new Product("Scratch Card", 130, 10);

            cart.addItem(cheese, 2);
            cart.addItem(tv, 1);
            cart.addItem(scratchCard, 1);

            customer.checkout(customer, cart);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    }
