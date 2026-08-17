package codeshop.codeshop.presentation.dto.response.product;

public record SearchProductResponseDto (
       String name,
       Long price,
       Long quantity,
       Boolean isPurchasable
) {
}
