package edu.miu.cs590.userservice.dto;

import edu.miu.cs590.userservice.enums.PaymentMethod;
import edu.miu.cs590.userservice.enums.Role;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDto {
    private Long id;
    private String email;
    private PaymentMethod paymentMethod;
    private String address1;
    private String address2;
    private String city;
    private String state;
    private String country;
    private String zipCode;
}
