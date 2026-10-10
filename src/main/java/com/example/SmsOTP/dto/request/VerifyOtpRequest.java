package com.example.SmsOTP.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VerifyOtpRequest {

    @NotBlank(message = "Mobile number is required")
    @Pattern(
            regexp = "^\\+[1-9]\\d{1,14}$",
            message = "Mobile number must be in E.164 format"
    )
    private String mobileNumber;

    @NotBlank(message = "OTP is required")
    @Pattern(
            regexp = "^\\d{6}$",
            message = "OTP must be exactly 6 digits"
    )
    private String otp;
}