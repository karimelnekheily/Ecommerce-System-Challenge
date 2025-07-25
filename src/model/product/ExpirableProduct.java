package model.product;




import java.time.LocalDate;

public class ExpirableProduct  extends Product implements ExpireItems {

    private LocalDate expiryDate;

    public ExpirableProduct(String name, int price, int quantity,LocalDate expiryDate) {
    super(name,price,quantity);
    this.expiryDate=expiryDate;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    @Override
    public boolean isExpired() {
        return expiryDate.isBefore(LocalDate.now());
    }
}
