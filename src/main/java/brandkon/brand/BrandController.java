package brandkon.brand;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class BrandController {

    private final BrandService brandService;

    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }

    @GetMapping("/brands")
    public List<BrandResponseDto> getBrands(@RequestParam(required = false) String category) {
        return brandService.getBrands(category);
    }

    @GetMapping("/brands/{brandId}")
    public BrandResponseDto getBrandDetail(@PathVariable Long brandId){
        return brandService.getBrandDetail(brandId);
    }
}