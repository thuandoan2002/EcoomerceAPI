package cmcglobal.vn.ecommerce.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ProductDTO {
    private long categoryId;
    @NotBlank(message = "Sku not blank!")
    private String sku;
    @NotBlank(message = "Name not blank!")
    private String name;
    @NotBlank(message = "Url not blank!")
    private String url;
    private String longDesc;
    private LocalDateTime dateCreated;
    private LocalDateTime lastUpdated;
    private long unlimited;
}
