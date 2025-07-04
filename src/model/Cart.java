package model;

import model.product.ExpirableProduct;
import model.product.Product;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<Product,Integer> items;
    public Cart(){
        items=new HashMap<Product,Integer>();
    }

    /**
     *
     * @param product
     * @param quantity
     */
    public void addItem(Product product,int quantity){
        if(product.getQuantity()<quantity){
            throw new IllegalArgumentException("product is out of stock");
        }
        items.put(product,quantity);
    }

    /**
     *
     * @param product
     * @param quantity
     */
    public void addItem(ExpirableProduct product, int quantity) {
        if (product.getQuantity() < quantity) {
            throw new IllegalArgumentException("product is out of stock");
        }
        if(product.isExpired()){
            throw new IllegalArgumentException("product is expired");

        }
        items.put(product, quantity);
    }

    /**
     *
     * @return totalCost
     */
    public double getSubtotal() {
        double subtotal = 0;
        for (Map.Entry<Product, Integer> entry : items.entrySet()) {
            subtotal += entry.getKey().getPrice() * entry.getValue();
        }
        return subtotal;
    }
    public Map<Product,Integer> getItems(){
        return items;
    }
    public void clearCart(){
        items.clear();
    }
    public void printCart(){
        for (Map.Entry<Product, Integer> entry : items.entrySet()) {
            System.out.println(entry.getValue()+ "X " + entry.getKey().getName() + " " + entry.getKey().getPrice());
        }
    }



    public boolean isEmpty() {
        return items.isEmpty();
    }
}
