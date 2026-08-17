package codeshop.codeshop.presentation.controller;

import codeshop.codeshop.application.ProductService;
import codeshop.codeshop.presentation.dto.response.product.GetProductResponseDto;
import codeshop.codeshop.presentation.dto.request.product.SearchProductCondition;
import codeshop.codeshop.presentation.dto.response.product.SearchProductResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<SearchProductResponseDto>> searchProduct(@ModelAttribute SearchProductCondition searchProductCondition) {
        return ResponseEntity.ok(productService.getProducts(searchProductCondition));
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetProductResponseDto> getProduct(@PathVariable Long id) {
        return ResponseEntity.ok(productService.getProduct(id));
    }
}
