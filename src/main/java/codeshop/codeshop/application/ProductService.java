package codeshop.codeshop.application;

import codeshop.codeshop.presentation.dto.ProductResponseDto;
import codeshop.codeshop.presentation.dto.ProductSearchCondition;
import codeshop.codeshop.presentation.dto.ProductSearchListResponseDto;

import java.util.List;

public interface ProductService {
    List<ProductSearchListResponseDto> getProducts(ProductSearchCondition productSearchCondition);

    ProductResponseDto getProduct(Long id);
}
