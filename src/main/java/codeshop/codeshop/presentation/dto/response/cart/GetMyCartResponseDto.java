package codeshop.codeshop.presentation.dto.response.cart;


import java.util.List;

public record GetMyCartResponseDto(
        List<MyCartItemResponseDto> cartItemList
) {
    record MyCartItemResponseDto(
            Long productId,

            Integer quantity,

            Boolean isPurchasable
    ) {
    }
}
