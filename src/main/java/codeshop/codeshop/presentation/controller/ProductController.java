package codeshop.codeshop.presentation.controller;

import codeshop.codeshop.application.ProductService;
import codeshop.codeshop.presentation.dto.response.product.GetProductResponseDto;
import codeshop.codeshop.presentation.dto.request.product.ProductSearchCondition;
import codeshop.codeshop.presentation.dto.response.product.GetProductsResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//TODO : api를 붙이네...? 왜?
@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<GetProductsResponseDto>> getProducts(@ModelAttribute ProductSearchCondition productSearchCondition) {
        //TODO : 실제 응답되는 형태 비교해서 responseEntity 활용법도 한 번 정리하기 (베스트 프랙티스)
        return ResponseEntity.ok(productService.getProducts(productSearchCondition));
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetProductResponseDto> getProduct(@PathVariable Long id) {
        //TODO : dto 변환 책임은 어디가 적절한지?
        return ResponseEntity.ok(productService.getProduct(id));
    }
}
