package cmcglobal.vn.ecommerce.dto;

import cmcglobal.vn.ecommerce.entity.CartEntity;
import cmcglobal.vn.ecommerce.entity.OrdersEntity;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import lombok.Data;

import java.util.Collection;

@Data
public class DiscountDTO {
    private String code;
    private int discountPercent;
    private byte status;

}
