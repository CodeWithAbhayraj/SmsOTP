# 📱 SMS OTP Authentication System

A secure and scalable **SMS OTP Authentication System** built with **Spring Boot**, **Java**, **MySQL**, and **Twilio API**. This project enables users to register, receive OTPs via SMS, verify their identity, and securely authenticate.

---

## 🚀 Features

- 🔐 User Registration
- 📩 SMS OTP Generation & Delivery
- ✅ OTP Verification
- 🔄 Resend OTP
- 🔑 Secure User Login
- 📡 RESTful APIs
- 🗄️ MySQL Database Integration
- ⚡ Spring Boot Validation
- 🛡️ Global Exception Handling
- 📖 Clean & Layered Architecture

---

## 🛠️ Tech Stack

| Technology | Version |
|------------|----------|
| Java | 21 |
| Spring Boot | 3.x |
| Spring Security | Latest |
| Spring Data JPA | Latest |
| MySQL | 8+ |
| Twilio API | Latest |
| Gradle | Latest |
| Lombok | Latest |

---

## 📂 Project Structure

```
src
├── main
│   ├── java
│   │   └── com/example/SmsOTP
│   │       ├── config
│   │       ├── controller
│   │       ├── dto
│   │       ├── entity
│   │       ├── exception
│   │       ├── repository
│   │       ├── service
│   │       └── SmsOtpApplication.java
│   └── resources
│       ├── application.properties
│       └── static
└── test
```

---

## ⚙️ Installation

### Clone Repository

```bash
git clone https://github.com/CodeWithAbhayraj/SmsOTP.git
```

### Navigate to Project

```bash
cd SmsOTP
```

### Configure Database

Update your `application.properties` file:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/your_database
spring.datasource.username=root
spring.datasource.password=your_password
```

### Configure Twilio Credentials

```properties
twilio.account.sid=YOUR_TWILIO_ACCOUNT_SID
twilio.auth.token=YOUR_TWILIO_AUTH_TOKEN
twilio.phone.number=YOUR_TWILIO_PHONE_NUMBER
```

### Run the Application

```bash
./gradlew bootRun
```

Windows:

```bash
gradlew.bat bootRun
```

---

## 📌 API Endpoints

| Method | Endpoint | Description |
|---------|----------|-------------|
| POST | `/api/auth/register` | Register User |
| POST | `/api/auth/verify-otp` | Verify OTP |
| POST | `/api/auth/resend-otp` | Resend OTP |
| POST | `/api/auth/login` | Login User |

---

## 📸 Screenshots

> Add screenshots of your application here.

Example:

- Registration API
- OTP Verification
- Login API
- Database Table

---

## 🔒 Security

- Password Encryption using BCrypt
- OTP-based Authentication
- Input Validation
- Layered Architecture
- Secure REST APIs

---

## 💡 Future Improvements

- JWT Authentication
- Redis OTP Storage
- Docker Support
- Swagger Documentation
- Email OTP Support
- Rate Limiting
- Role-Based Authorization

---

## 🤝 Contributing

Contributions are welcome!

1. Fork this repository
2. Create your feature branch
3. Commit your changes
4. Push to your branch
5. Open a Pull Request

---

## 👨‍💻 Author

**Abhayraj Konge**

- GitHub: https://github.com/CodeWithAbhayraj
- LinkedIn: https://www.linkedin.com/in/abhayraj-konge/

---

## ⭐ Support

If you found this project useful, don't forget to **⭐ Star this repository**.
