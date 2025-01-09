package brandkon.product;

import brandkon.brand.Brand;
import brandkon.brand.BrandRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final BrandRepository brandRepository;

    public ProductService(ProductRepository productRepository, BrandRepository brandRepository) {
        this.productRepository = productRepository;
        this.brandRepository = brandRepository;
    }

    // 상품 목록 조회
    public List<ProductResponseDto> getProducts(Long brandId) {
        List<Product> products = (brandId != null) ? productRepository.findByBrandId(brandId) : productRepository.findAll();
        return products.stream()
                .map(product -> new ProductResponseDto(
                        product.getId(),
                        product.getBrand().getName(),
                        product.getProductName(),
                        product.getPrice(),
                        product.getImageUrl(),
                        product.getExpirationDays() // expirationDays 추가
                ))
                .collect(Collectors.toList());
    }

    // 인기 상품 목록 조회
    public List<ProductResponseDto> getPopularProducts(Long categoryId, Long brandId) {
        List<Product> products;

        if (categoryId != null) {
            products = productRepository.findPopularByCategoryId(categoryId);
        } else if (brandId != null) {
            products = productRepository.findPopularByBrandId(brandId);
        } else {
            products = productRepository.findAll();
        }

        return products.stream()
                .limit(5)
                .map(product -> new ProductResponseDto(
                        product.getId(),
                        product.getBrand().getName(),
                        product.getProductName(),
                        product.getPrice(),
                        product.getImageUrl(),
                        product.getExpirationDays() // expirationDays 추가
                ))
                .collect(Collectors.toList());
    }

    // 상품 상세 조회
    public ProductDetailResponseDto getProductDetail(Long productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        Brand brand = brandRepository.findById(product.getBrand().getId())
                .orElseThrow(() -> new RuntimeException("Brand not found"));

        return new ProductDetailResponseDto(
                product.getId(),
                product.getProductName(),
                product.getPrice(),
                new ProductDetailResponseDto.BrandDto(
                        brand.getId(),
                        brand.getName(),
                        "#사용처 - 전국 메가MGC커피 매장에서 사용 가능합니다. #제한사항 - 사진은 이미지 컷이므로 실제와 다를 수 있습니다. #유의사항 - *지급보증 : 본 상품은 별도의 지급보증 및 피해보상보험계약체결 없이 자체 신용으로 발행되었습니다."
                ),
                product.getExpirationDays() // 유효기간 추가
        );
    }
}