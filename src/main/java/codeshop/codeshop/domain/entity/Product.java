package codeshop.codeshop.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //TODO : product랑 붙여서 네이밍해야하는지?
    private String name;

    //TODO : long이 적절한지?
    private long price;

    private long quantity;

    private boolean isSaleAvailable;

    protected Product(){};

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public long getPrice() {
        return price;
    }

    public long getQuantity() {
        return quantity;
    }

    public boolean isSaleAvailable() {
        return isSaleAvailable;
    }
}
