package codeshop.codeshop.presentation.dto.request.cart;

import lombok.Getter;

@Getter
public class ModifyCartItemQuantityRequestDto {

    public Long productId;

    public int quantity;
}
