package codeshop.codeshop.application;

import codeshop.codeshop.domain.entity.Product;
import codeshop.codeshop.infra.ProductRepository;
import codeshop.codeshop.presentation.dto.ProductResponseDto;
import codeshop.codeshop.presentation.dto.ProductSearchCondition;
import codeshop.codeshop.presentation.dto.ProductSearchListResponseDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    // TODO : 왜 생성자 주입이 best 였었는지?
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<ProductSearchListResponseDto> getProducts(ProductSearchCondition productSearchCondition) {
        List<Product> productList = productRepository.findProductsBySearchCondition(productSearchCondition);
        List<ProductSearchListResponseDto> productSearchListResponseDtoList = new ArrayList<>();
        // TODO : 반복문 말고 람다나 다른 걸 활용하는 건 어떤 이유에서일까?
        for (Product product : productList) {
            productSearchListResponseDtoList.add(ProductSearchListResponseDto.from(product));
        }
        //TODO : dto 변환 책임은 어디가 지는게 좋은가?
        return productSearchListResponseDtoList;
    }

    @Override
    public ProductResponseDto getProduct(Long id) {
        //TODO : get과 find 알리아스 뭐가 다른가?
        return productRepository.findOneById(id)
                .map(ProductResponseDto::from)
                //TODO : exception 처리 전략 정하기
                .orElseThrow(() -> new RuntimeException("상품 데이터가 조회되지 않습니다"));
    }
}
