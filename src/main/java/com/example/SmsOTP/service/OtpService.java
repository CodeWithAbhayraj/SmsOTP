package com.example.SmsOTP.service;

import com.example.SmsOTP.dto.request.SendOtpRequest;
import com.example.SmsOTP.dto.request.VerifyOtpRequest;
import com.example.SmsOTP.dto.response.ApiResponse;

public interface OtpService {

    // Send OTP to Mobile Number
    ApiResponse sendOtp(SendOtpRequest request);

    // Verify OTP
    ApiResponse verifyOtp(VerifyOtpRequest request);

    // Resend OTP
    ApiResponse resendOtp(SendOtpRequest request);
}