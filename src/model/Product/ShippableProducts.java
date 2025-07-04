package model.Product;

public class ShippableProducts extends product implements ShippableItems{

    private double weight;
    public ShippableProducts(String name,int price,int quantity,double weight){
        super(name,price,quantity);
        this.weight=weight;
    }
    @Override
    public double getWeight() {
        return weight;
    }
}
