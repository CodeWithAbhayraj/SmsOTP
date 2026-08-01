package com.example.SmsOTP.repository;

import com.example.SmsOTP.entity.OtpVerification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OtpRepository extends JpaRepository<OtpVerification, Long> {

    // Mobile Number se latest OTP find karne ke liye
    Optional<OtpVerification> findTopByMobileNumberOrderByCreatedAtDesc(String mobileNumber);

    // Mobile Number aur OTP dono match karne ke liye
    Optional<OtpVerification> findByMobileNumberAndOtp(String mobileNumber, String otp);

    // Mobile Number exist karta hai ya nahi
    boolean existsByMobileNumber(String mobileNumber);
}