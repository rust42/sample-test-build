package edu.miu.cs590.userservice.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import edu.miu.cs590.userservice.enums.PaymentMethod;
import edu.miu.cs590.userservice.enums.Role;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class UserSaveDto {

    @NotBlank
    @Email
    private String email;
    @NotBlank
    private String password;
    @JsonIgnore
    private Role role = Role.USER;
    @NotNull
    private PaymentMethod paymentMethod;
    @NotBlank
    private String address1;
    private String address2;
    @NotBlank
    private String city;
    @NotBlank
    private String state;
    @NotBlank
    private String country;
    @NotBlank
    private String zipCode;

}
