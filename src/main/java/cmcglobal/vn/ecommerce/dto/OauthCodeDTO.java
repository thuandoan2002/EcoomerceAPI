package cmcglobal.vn.ecommerce.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class OauthCodeDTO {
    @NotBlank(message = "code not blank!")
    private String code;
    @NotBlank(message = "Authentication not blank!")
    private String authentication;
}
