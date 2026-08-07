package codeshop.codeshop.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;

@Entity
@Getter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //TODO : product랑 붙여서 네이밍해야하는지?
    private String name;

    //TODO : long이 적절한지?
    private long price;

    private long quantity;

    //TODO : Boolean이랑 또 뭐가 다를지?
    private boolean isOnSale;

    public static boolean isPurchasable(Product product) {
        long quantity = product.getQuantity();
        boolean isOnSale = product.isOnSale();
        return quantity > 0 && isOnSale;
    }

    protected Product() {
    }
}
