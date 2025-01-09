package brandkon.brand;

import brandkon.category.Category;

import jakarta.persistence.*;
@Entity
public class Brand {

    @Id
    private Long id;
    private String name;
    private String imageUrl;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
