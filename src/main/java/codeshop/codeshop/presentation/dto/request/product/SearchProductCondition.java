package codeshop.codeshop.presentation.dto.request.product;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;

public record SearchProductCondition(
        @NotBlank
        String productName,

        @PositiveOrZero
        Integer page,

        @PositiveOrZero
        Integer size,

        @NotBlank
        String sort,

        @NotBlank
        String direction
) {
}
