package codeshop.codeshop.domain.entity;

import jakarta.persistence.*;

@Entity
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cart_id")
    //TODO : 연관관계 주인 어떻게 잡는지 다시 정립
    private Cart cart;

    //TODO : Product 엔티티 자체를 관계 맺는 것과 비교해보기
    private Long productId;

    private int quantity;

    private boolean isOnSale;

    protected CartItem(){}

    public Long getId() {
        return id;
    }

    public Cart getCart() {
        return cart;
    }

    public Long getProductId() {
        return productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public boolean isOnSale() {
        return isOnSale;
    }
}
