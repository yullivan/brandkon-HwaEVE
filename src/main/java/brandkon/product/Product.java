package brandkon.product;

import brandkon.brand.Brand;
import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@EntityListeners(AuditingEntityListener.class) // Add this to enable auditing
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String productName;
    private int price;
    private int expirationDays;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;

    @CreatedDate
    private LocalDateTime createdAt; // createdDateTime

    @LastModifiedDate
    private LocalDateTime updatedAt; // modifiedDateTime

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public String getProductName() {
        return productName;
    }

    public int getPrice() {
        return price;
    }

    public int getExpirationDays() {
        return expirationDays;
    }

    public Brand getBrand() {
        return brand;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }
}