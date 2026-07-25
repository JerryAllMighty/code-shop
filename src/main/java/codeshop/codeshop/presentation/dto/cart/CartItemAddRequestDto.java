package codeshop.codeshop.presentation.dto.cart;

import codeshop.codeshop.domain.entity.Cart;

public class CartItemAddRequestDto {
    public Cart cart;

    //TODO : Product 엔티티 자체를 관계 맺는 것과 비교해보기
    public Long productId;

    public int quantity;

    public boolean isOnSale;
}
