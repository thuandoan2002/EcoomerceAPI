package cmcglobal.vn.ecommerce.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserDTO {
    @NotBlank(message = "Email not blank!")
    private String email;
    private String firstName;
    private String lastName;
    private String city;
    @NotBlank(message = "State not blank!")
    private String state;
    private String phone;
    private String country;
    private String address;
    private int emailVeryfied;
    private String zip;
    private LocalDateTime registrationDate;
    @NotBlank(message = "Password not blank!")
    private String password;



}
