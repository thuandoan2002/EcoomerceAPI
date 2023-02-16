package cmcglobal.vn.ecommerce.dto;

import cmcglobal.vn.ecommerce.entity.CartItemEntity;
import cmcglobal.vn.ecommerce.entity.DiscountEntity;
import cmcglobal.vn.ecommerce.entity.UserEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;
import java.util.Collection;

@Data
public class CartDTO {

   private String email;
   private long productVariantId;
   private int amount;
}
