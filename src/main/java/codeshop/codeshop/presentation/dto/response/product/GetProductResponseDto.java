package codeshop.codeshop.presentation.dto.response.product;

import codeshop.codeshop.domain.entity.Product;

public record GetProductResponseDto(
        String name,
        Long price,
        Long quantity,
        Boolean isPurchasable
) {
}
