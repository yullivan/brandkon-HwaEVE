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

    private String guidelines;

    public Brand() {
    }

    public Brand(String name, String imageUrl, Category category, String guidelines) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.category = category;
        this.guidelines = guidelines;
    }

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

    public String getGuidelines() {
        return guidelines;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}