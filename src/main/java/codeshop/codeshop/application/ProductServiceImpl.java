package codeshop.codeshop.application;

import codeshop.codeshop.domain.entity.Product;
import codeshop.codeshop.infra.ProductRepository;
import codeshop.codeshop.presentation.dto.ProductSearchCondition;
import codeshop.codeshop.presentation.dto.ProductSearchResponseDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    // TODO : 왜 생성자 주입이 best 였었는지?
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<ProductSearchResponseDto> getProducts(ProductSearchCondition productSearchCondition) {
        List<Product> productList = productRepository.findProductsBySearchCondition(productSearchCondition);
        //TODO : dto 변환
        List<ProductSearchResponseDto> productSearchResponseDtoList = new ArrayList<>();
//        for (Product product : productList) {
//            productSearchResponseDtoList.add(ProductSearchResponseDto.builder()
//                    .name(product.getName())
//                    .price(product.getPrice())
//                    .quantity(product.getQuantity())
//                    .isSaleAvailable(product.isSaleAvailable())
//                    .build());
//
//        }
        //TODO : dto 변환 책임은 어디가 지는게 좋은가?
        return productSearchResponseDtoList;
    }

    @Override
    public Optional<Product> getProduct(Long id) {
        //TODO : get과 find 알리아스 뭐가 다른가?
        return productRepository.findOneById(id);
    }
}
