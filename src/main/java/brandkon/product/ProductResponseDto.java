package brandkon.product;

public record ProductResponseDto(
        Long id,
        String brandName,
        String productName,
        int price,
        int expirationDays
) {}
