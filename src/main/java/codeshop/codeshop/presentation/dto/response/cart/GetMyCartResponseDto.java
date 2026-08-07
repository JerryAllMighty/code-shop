package codeshop.codeshop.presentation.dto.response.cart;

import lombok.Getter;

import java.util.List;

@Getter
public class GetMyCartResponseDto {
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
