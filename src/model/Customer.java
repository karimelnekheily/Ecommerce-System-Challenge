package model;

import model.product.Product;
import model.product.ShippableItems;
import service.ServiceShipping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Customer {
    private String name;
    private double balance;

    private Cart cart;
    public Customer(String name,double balance,Cart cart){
        this.name=name;
        this.balance=balance;
        this.cart=cart;
    }
    public void checkout(Customer customer,Cart cart){
        double shippingFees=30.0;
        double totalAmount;
        if(customer.getCart().isEmpty()){
            throw new IllegalArgumentException("Cart is empty ");
        }
        double Subtotal=customer.getCart().getSubtotal();
        if(customer.getBalance()< Subtotal){
            throw new IllegalArgumentException("Customer's balance is insufficient");
        }
        List<ShippableItems>  shipItems=new ArrayList<>();
        for(Map.Entry<Product,Integer> entry :cart.getItems().entrySet()){
            Product product=entry.getKey();
            int quantity= entry.getValue();

            if(product instanceof ShippableItems){
                for (int i = 0; i < quantity; i++) {
                    shipItems.add((ShippableItems) product);
                }
            }

        }
        ServiceShipping.ship(shipItems);
        totalAmount = Subtotal + shippingFees;
        customer.balance -= totalAmount;
        System.out.println("\n** Checkout Receipt **");
        customer.getCart().printCart();
        System.out.println("-----------------------");
        System.out.println("Subtotal: " + Subtotal);
        System.out.println("Shipping : " + shippingFees);
        System.out.println("Amount: " + totalAmount);
        System.out.println("Remaining Balance: " + balance);
        System.out.println("Checkout successful! 🎉\n");

        cart.clearCart();


    }

    public String getName() {
        return name;
    }

    private double getBalance() {
        return balance;
    }

    private Cart getCart() {
        return cart;
    }


}
