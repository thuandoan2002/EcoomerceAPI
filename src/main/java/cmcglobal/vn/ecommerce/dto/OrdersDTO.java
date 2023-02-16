package cmcglobal.vn.ecommerce.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Data
public class OrdersDTO {
    private int userId;
    private String shipName;
    private String shipAddress;
    private String billingAddress;
    private String city;
    private String state;
    private String zip;
    private String country;
    private String phone;
    private double totalPrice;
    private double totalCargoPrice;
    private Integer discountId;

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime date;
    private byte shipped;
    private String cargoFirm;
    private String trackingNumber;

}
