package brandkon.product;

public record ProductResponseDto(
        Long id,
        String brandName,
        String name,
        int price,
        int expirationDays
) {}
