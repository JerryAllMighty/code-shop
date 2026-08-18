package codeshop.codeshop.application;

import codeshop.codeshop.common.exception.ProductDataNotFoundException;
import codeshop.codeshop.domain.entity.Product;
import codeshop.codeshop.infra.ProductRepository;
import codeshop.codeshop.presentation.dto.response.product.GetProductResponseDto;
import codeshop.codeshop.presentation.dto.request.product.SearchProductCondition;
import codeshop.codeshop.presentation.dto.response.product.SearchProductResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public SearchProductResponseDto searchProducts(SearchProductCondition searchProductCondition) {
        Pageable pageable = PageRequest.of(searchProductCondition.page(), searchProductCondition.size(), Sort.Direction.fromString(searchProductCondition.direction()));
        Page<Product> productPage = productRepository.findProductsBySearchCondition(searchProductCondition, pageable);
        return new SearchProductResponseDto(
                productPage.map(product ->
                                new SearchProductResponseDto.ProductContentDto(product.getName(),
                                        product.getPrice()
                                        , product.getQuantity()
                                        , product.isOnSale()))
                        .toList()
                , productPage.getNumber()
                , productPage.getSize()
                , productPage.getTotalElements()
                , productPage.getTotalPages()
                , productPage.isFirst()
                , productPage.isLast());
    }

    @Override
    public GetProductResponseDto getProduct(Long id) {
        Product foundProduct = productRepository.findById(id)
                .orElseThrow(ProductDataNotFoundException::new);
        return new GetProductResponseDto(
                foundProduct.getName()
                , foundProduct.getPrice()
                , foundProduct.getQuantity()
                , foundProduct.isOnSale()
        );
    }
}
