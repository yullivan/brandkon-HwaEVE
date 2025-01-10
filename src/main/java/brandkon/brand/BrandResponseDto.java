package brandkon.brand;

public record BrandResponseDto(
        Long id,
        String name,
        String imageUrl,
        String categoryName,
        String guidelines
) {
}