package kr.latera.customvalidationtest.web;

import kr.latera.customvalidationtest.web.validator.UniqueEmail;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UserRegisterRequestDto {
    @NotBlank
    @Size(min = 2, max = 12)
    private String username;
    @UniqueEmail
    @Email
    private String email;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
