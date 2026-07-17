package codeshop.codeshop.presentation.controller;

import codeshop.codeshop.application.ProductService;
import codeshop.codeshop.domain.entity.Product;
import codeshop.codeshop.presentation.dto.ProductSearchCondition;
import codeshop.codeshop.presentation.dto.ProductSearchResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//TODO : 왜 기본적으로 복수형이럣더라..?
//TODO : api를 붙이네...? 왜?
@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<ProductSearchResponseDto>> getProducts(@ModelAttribute ProductSearchCondition productSearchCondition) {
        //TODO : 실제 응답되는 형태 비교해서 responseEntity 활용법도 한 번 정리하기 (베스트 프랙티스)
        return ResponseEntity.ok(productService.getProducts(productSearchCondition));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Product>> getProduct(@PathVariable Long id) {
        //TODO : 만약 변수가 long이였으면 어떤 문제가 생겼을지?
        Optional<Product> product = productService.getProduct(id);
        //TODO : responseDto로 매핑
        //TODO : dto 변환 책임은 어디가 적절한지?
        return ResponseEntity.ok(product);
    }
}
