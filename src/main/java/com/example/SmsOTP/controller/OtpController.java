package com.example.SmsOTP.controller;

import com.example.SmsOTP.dto.request.SendOtpRequest;
import com.example.SmsOTP.dto.request.VerifyOtpRequest;
import com.example.SmsOTP.dto.response.ApiResponse;
import com.example.SmsOTP.service.OtpService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/otp")
@RequiredArgsConstructor
public class OtpController {

    private final OtpService otpService;

    // Send OT


    @PostMapping("/send")
    public ResponseEntity<ApiResponse> sendOtp(
            @Valid @RequestBody SendOtpRequest request) {

        ApiResponse response = otpService.sendOtp(request);

        return ResponseEntity.ok(response);
    }

    // Verify OTP
    @PostMapping("/verify")
    public ResponseEntity<ApiResponse> verifyOtp(
            @Valid @RequestBody VerifyOtpRequest request) {

        ApiResponse response = otpService.verifyOtp(request);

        return ResponseEntity.ok(response);
    }

    // Resend OTP
    @PostMapping("/resend")
    public ResponseEntity<ApiResponse> resendOtp(
            @Valid @RequestBody SendOtpRequest request) {

        ApiResponse response = otpService.resendOtp(request);

        return ResponseEntity.ok(response);
    }
}