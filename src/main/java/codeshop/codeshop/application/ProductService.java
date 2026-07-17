package codeshop.codeshop.application;

import codeshop.codeshop.domain.entity.Product;
import codeshop.codeshop.presentation.dto.ProductSearchCondition;
import codeshop.codeshop.presentation.dto.ProductSearchResponseDto;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<ProductSearchResponseDto> getProducts(ProductSearchCondition productSearchCondition);

    Optional<Product> getProduct(Long id);
}
