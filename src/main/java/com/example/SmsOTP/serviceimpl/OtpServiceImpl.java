package com.example.SmsOTP.serviceimpl;

import com.example.SmsOTP.config.TwilioConfig;
import com.example.SmsOTP.entity.OtpVerification;
import com.example.SmsOTP.repository.OtpRepository;
import com.example.SmsOTP.dto.request.SendOtpRequest;
import com.example.SmsOTP.dto.request.VerifyOtpRequest;
import com.example.SmsOTP.dto.response.ApiResponse;
import com.example.SmsOTP.service.OtpService;
import com.example.SmsOTP.util.OtpGenerator;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OtpServiceImpl implements OtpService {

    private final OtpRepository otpRepository;
    private final OtpGenerator otpGenerator;
    private final TwilioConfig twilioConfig;

    @Override
    public ApiResponse sendOtp(SendOtpRequest request) {

        String otp = otpGenerator.generateOtp();

        OtpVerification otpVerification = OtpVerification.builder()
                .mobileNumber(request.getMobileNumber())
                .otp(otp)
                .verified(false)
                .expiryTime(LocalDateTime.now().plusMinutes(5))
                .build();

        otpRepository.save(otpVerification);


        Message.creator(
                new PhoneNumber(request.getMobileNumber()),
                new PhoneNumber(twilioConfig.getPhoneNumber()),
                "Hello Darling, Tell Me Your OTP Plz : " + otp + "\nFast Becoz; OTP Valid For Only 5 minutes."
        ).create();

        return ApiResponse.builder()
                .status(200)
                .message("OTP Sent Successfully")
                .data(null)
                .build();
    }

    @Override
    public ApiResponse verifyOtp(VerifyOtpRequest request) {

        Optional<OtpVerification> optionalOtp =
                otpRepository.findByMobileNumberAndOtp(
                        request.getMobileNumber(),
                        request.getOtp()
                );

        if (optionalOtp.isEmpty()) {
            return ApiResponse.builder()
                    .status(400)
                    .message("Invalid OTP")
                    .build();
        }

        OtpVerification otp = optionalOtp.get();

        if (otp.getExpiryTime().isBefore(LocalDateTime.now())) {

            return ApiResponse.builder()
                    .status(400)
                    .message("OTP Expired")
                    .build();
        }

        otp.setVerified(true);

        otpRepository.save(otp);

        return ApiResponse.builder()
                .status(200)
                .message("OTP Verified Successfully")
                .build();
    }

    @Override
    public ApiResponse resendOtp(SendOtpRequest request) {

        String otp = otpGenerator.generateOtp();

        OtpVerification otpVerification = OtpVerification.builder()
                .mobileNumber(request.getMobileNumber())
                .otp(otp)
                .verified(false)
                .expiryTime(LocalDateTime.now().plusMinutes(5))
                .build();

        otpRepository.save(otpVerification);

        Message.creator(
                new PhoneNumber(request.getMobileNumber()),
                new PhoneNumber(twilioConfig.getPhoneNumber()),
                "Your New OTP is: " + otp + "\nValid for 5 minutes."
        ).create();

        return ApiResponse.builder()
                .status(200)
                .message("OTP Resent Successfully")
                .build();
    }
}