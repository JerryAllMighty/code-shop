package codeshop.codeshop.infra;

import codeshop.codeshop.domain.entity.Product;
import codeshop.codeshop.presentation.dto.request.product.SearchProductCondition;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductRepositoryCustom {
    Page<Product> findProductsBySearchCondition(SearchProductCondition searchProductCondition, Pageable pageable);
}
