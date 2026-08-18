package codeshop.codeshop.presentation.dto.response.product;

import java.util.List;

public record SearchProductResponseDto(
        List<ProductContentDto> content,
        Integer pageNumber,
        Integer pageSize,
        Long totalElements,
        Integer totalPages,
        Boolean isFirst,
        Boolean isLast

) {
    public record ProductContentDto(
            String name,
            Long price,
            Long quantity,
            Boolean isPurchasable) {
    }
}
