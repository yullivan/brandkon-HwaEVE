package brandkon.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    // 브랜드 ID로 상품 조회
    List<Product> findByBrandId(Long brandId);

    // 카테고리 ID로 인기 상품 조회 (카테고리에 해당하는 상품을 최신순으로 가져오기)
    @Query("SELECT p FROM Product p JOIN p.brand b WHERE b.category.id = :categoryId ORDER BY p.id DESC")
    List<Product> findPopularByCategoryId(@Param("categoryId") Long categoryId);

    // 브랜드 ID로 인기 상품 조회 (브랜드에 해당하는 상품을 최신순으로 가져오기)
    @Query("SELECT p FROM Product p WHERE p.brand.id = :brandId ORDER BY p.id DESC")
    List<Product> findPopularByBrandId(@Param("brandId") Long brandId);
}