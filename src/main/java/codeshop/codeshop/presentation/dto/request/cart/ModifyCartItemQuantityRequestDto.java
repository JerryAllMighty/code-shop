package codeshop.codeshop.presentation.dto.request.cart;

public record ModifyCartItemQuantityRequestDto(
        Long productId,
        Integer quantity
) {
}
