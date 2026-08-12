package codeshop.codeshop.application;

import codeshop.codeshop.common.exception.ProductDataNotFoundException;
import codeshop.codeshop.domain.entity.Product;
import codeshop.codeshop.infra.ProductRepository;
import codeshop.codeshop.presentation.dto.response.product.GetProductResponseDto;
import codeshop.codeshop.presentation.dto.request.product.ProductSearchCondition;
import codeshop.codeshop.presentation.dto.response.product.GetProductsResponseDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    // TODO : 왜 생성자 주입이 best 였었는지?
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<GetProductsResponseDto> getProducts(ProductSearchCondition productSearchCondition) {
        List<Product> productList = productRepository.findProductsBySearchCondition(productSearchCondition);
        List<GetProductsResponseDto> getProducts = new ArrayList<>();
        // TODO : 반복문 말고 람다나 다른 걸 활용하는 건 어떤 이유에서일까?
        for (Product product : productList) {
            getProducts.add(GetProductsResponseDto.from(product));
        }
        //TODO : dto 변환 책임은 어디가 지는게 좋은가?
        return getProducts;
    }

    @Override
    public GetProductResponseDto getProduct(Long id) {
        //TODO : get과 find 알리아스 뭐가 다른가?
        return productRepository.findOneById(id)
                .map(GetProductResponseDto::from)
                .orElseThrow(ProductDataNotFoundException::new);
    }
}
