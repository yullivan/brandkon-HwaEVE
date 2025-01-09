package brandkon.product;

public record ProductDetailResponseDto(
        Long id,
        String productName,
        int price,
        BrandDto brand,
        int expirationDays
) {
    public record BrandDto(Long id, String name, String guidelines) {}
}