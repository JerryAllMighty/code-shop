package codeshop.codeshop.infra;

import codeshop.codeshop.domain.entity.Product;
import codeshop.codeshop.presentation.dto.ProductSearchCondition;

import java.util.List;

public interface ProductRepositoryCustom {
    List<Product> findProductsBySearchCondition(ProductSearchCondition productSearchCondition);
}
