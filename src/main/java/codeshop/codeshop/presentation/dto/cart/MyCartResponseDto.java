package codeshop.codeshop.presentation.dto.cart;

import java.util.List;

public class MyCartResponseDto {
    public List<MyCartItemResponseDto> cartItemList;

    public static class MyCartItemResponseDto {
        public Long productId;

        public int quantity;

        public boolean isPurchasable;

        public MyCartItemResponseDto(Long productId, int quantity, boolean isPurchasable) {
            this.productId = productId;
            this.quantity = quantity;
            this.isPurchasable = isPurchasable;
        }
    }
}
