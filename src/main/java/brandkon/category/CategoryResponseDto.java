package brandkon.category;

public record CategoryResponseDto(
        Long id,
        String name,
        String slug,
        String imageUrl
) {
}