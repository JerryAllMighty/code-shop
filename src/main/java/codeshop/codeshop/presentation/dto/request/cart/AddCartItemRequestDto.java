package codeshop.codeshop.presentation.dto.request.cart;

public record AddCartItemRequestDto(
       Long productId,
       Integer quantity,
       Boolean isOnSale
) {
}
