package model.Product;

public class ShippableExpirableProduct extends product implements ExpireItems,ShippableItems{



    @Override
    public boolean isExpired() {
        return false;
    }

    @Override
    public double getWeight() {
        return 0;
    }
}
