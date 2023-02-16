package cmcglobal.vn.ecommerce.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CartDecreaseDTO {
    private long cartId;
    private long productVariantId;
    private BigDecimal amountDecrease;
}
