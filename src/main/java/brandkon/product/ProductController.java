package brandkon.product;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // 상품 목록 조회
    @GetMapping("/products")
    public List<ProductResponseDto> getProducts(@RequestParam(required = false) Long brandId) {
        return productService.getProducts(brandId);
    }

    // 인기 상품 목록 조회
    @GetMapping("/products/popular")
    public List<ProductResponseDto> getPopularProducts(@RequestParam(required = false) Long categoryId,
                                                       @RequestParam(required = false) Long brandId) {
        return productService.getPopularProducts(categoryId, brandId);
    }

    // 상품 상세 조회
    @GetMapping("/products/{productId}")
    public ResponseEntity<ProductDetailResponseDto> getProductDetail(@PathVariable Long productId) {
        ProductDetailResponseDto productDetail = productService.getProductDetail(productId);
        return ResponseEntity.ok(productDetail);
    }
}