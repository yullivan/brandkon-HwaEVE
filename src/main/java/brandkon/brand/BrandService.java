package brandkon.brand;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BrandService {
    private final BrandRepository brandRepository;

    public BrandService(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    public List<BrandResponseDto> getBrands(String categorySlug) {
        return brandRepository.findByCategory_Slug(categorySlug).stream()
                .map(brand -> new BrandResponseDto(
                        brand.getId(),
                        brand.getName(),
                        brand.getImageUrl(),
                        brand.getCategory().getName() // Category name 추가
                ))
                .collect(Collectors.toList());
    }

    public BrandResponseDto getBrandDetail(Long brandId) {
        Brand brand = brandRepository.findById(brandId)
                .orElseThrow(() -> new RuntimeException("Brand not found"));
        return new BrandResponseDto(
                brand.getId(),
                brand.getName(),
                brand.getImageUrl(),
                brand.getCategory().getName() // Category name 추가
        );
    }
}