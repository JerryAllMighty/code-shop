package codeshop.codeshop.application;

import codeshop.codeshop.presentation.dto.response.product.GetProductResponseDto;
import codeshop.codeshop.presentation.dto.request.product.SearchProductCondition;
import codeshop.codeshop.presentation.dto.response.product.SearchProductResponseDto;

public interface ProductService {
    SearchProductResponseDto searchProducts(SearchProductCondition searchProductCondition);
    GetProductResponseDto getProduct(Long id);
}
