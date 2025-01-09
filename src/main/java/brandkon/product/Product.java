package brandkon.product;

import brandkon.brand.Brand;
import jakarta.persistence.*;

@Entity
public class Product {

    @Id
    private Long id;

    @Column(name = "product_name")
    private String productName;

    private int price;
    private int expirationDays;
    private String imageUrl;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;

    public Product() {
    }

    public Product(String productName, int price, int expirationDays, String imageUrl, Brand brand) {
        this.productName = productName;
        this.price = price;
        this.expirationDays = expirationDays;
        this.imageUrl = imageUrl;
        this.brand = brand;
    }

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

    public String getImageUrl() {
        return imageUrl;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }
}