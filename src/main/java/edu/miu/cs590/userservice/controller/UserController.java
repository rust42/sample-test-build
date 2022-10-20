package edu.miu.cs590.userservice.controller;

import edu.miu.cs590.userservice.dto.UserDto;
import edu.miu.cs590.userservice.dto.UserSaveDto;
import edu.miu.cs590.userservice.dto.UserVerifyDto;
import edu.miu.cs590.userservice.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@CrossOrigin("http://localhost:3000")
public class UserController {

    private UserService userService;
    private UserDetailsService userDetailsService;

    public UserController(UserService userService,UserDetailsService userDetailsService) {
        this.userService = userService;
        this.userDetailsService=userDetailsService;
    }

    @PostMapping("/signup")
    UserDto saveUser(@RequestBody @Valid UserSaveDto userSaveDto){
        return userService.saveUser(userSaveDto);
    }

    @PostMapping("/verify")
    Boolean verifyUserDetailsByUsername(@RequestBody @Valid UserVerifyDto userVerifyDto){
        UserDetails userDetails = userDetailsService.loadUserByUsername(userVerifyDto.getEmail());
        return userDetails!=null
                && userDetails.isAccountNonExpired()
                && userDetails.isAccountNonLocked()
                && userDetails.isEnabled()
                && userDetails.isCredentialsNonExpired();
    }
}
