#  Inactive API Simple Demo

This is a **Spring Boot demo project** that shows how to **gracefully disable or block deprecated REST APIs** in an application using a **custom annotation** (`@InactiveApi`) and **Spring AOP**.

It also includes a **configurable switch** to enable or disable inactive API blocking at runtime using **Spring Boot Actuator** and **Spring Cloud RefreshScope** — without restarting the application.

---

## Features

✅ Annotate deprecated endpoints with `@InactiveApi`  
✅ Automatically block inactive APIs with HTTP **410 Gone** JSON response  
✅ Console logs showing which APIs were blocked  
✅ Configurable toggle: enable/disable blocking dynamically  
✅ Lightweight and minimal — no DB or service layer  
✅ Works out-of-the-box with Spring Boot 3.x and Java 17+

---

## Project Structure

```
inactive-api-simple/
 ├── src/
 │   ├── main/java/com/javapoc/
 │   │   ├── annotation/InactiveApi.java
 │   │   ├── aspect/InactiveApiAspect.java
 │   │   ├── config/InactiveApiConfig.java
 │   │   ├── controller/DemoController.java
 │   │   └── InactiveApiSimpleApplication.java
 │   └── resources/
 │       └── application.properties
 ├── pom.xml
 └── README.md
```

---

## ⚙️ Setup Instructions

### 1️⃣ Clone the repository
```bash
git clone https://github.com/pallala1989/inactive-api-simple.git
cd inactive-api-simple
```

### 2️⃣ Open in IntelliJ IDEA
- Go to **File → Open**
- Select the project folder
- Let IntelliJ import Maven dependencies automatically.

### 3️⃣ Build the project
```bash
mvn clean install
```

### 4️⃣ Run the application
`run `InactiveApiSimpleApplication.java` directly from IntelliJ.

You should see:
```
Inactive API Simple Demo started successfully...
```

---

## API Endpoints

| Endpoint | Method | Description | Status |
|-----------|---------|-------------|---------|
| `/demo/active` | GET | Returns a normal active response | ✅ Active |
| `/demo/hello` | POST | Returns greeting message | ✅ Active |
| `/demo/inactive` | GET | Blocked API (if blocking is enabled) | 🚫 Inactive |

### Example Responses

####  Active API
```
GET http://localhost:8080/demo/active
```
Response:
```json
"This is an ACTIVE API response."
```

####  Inactive API (when blocking is ON)
```
GET http://localhost:8080/demo/inactive
```
Response:
```json
{
  "status": 410,
  "error": "Gone",
  "message": "This API is inactive. Please contact support team."
}
```

---

## 🔄 Dynamic Config Refresh (Optional)

If you want to enable/disable inactive API blocking at runtime:

### Add in `application.properties`
```properties
inactive.api.block=true
management.endpoints.web.exposure.include=refresh
```

### Change config dynamically

1. Update property to `false` (for disabling blocking)
2. POST to refresh endpoint:
```bash
curl -X POST http://localhost:8080/actuator/refresh ( I have disabled it for now  )
```

Now `/demo/inactive` will start responding normally.

---

##  How It Works

- `@InactiveApi` is a custom annotation you place on controller methods you want to mark inactive.
- `InactiveApiAspect` intercepts those methods before execution.
- If blocking is enabled (`inactive.api.block=true`), it throws an exception, which is handled and returned as a clean JSON 410 response.
- You can disable blocking dynamically using Spring Cloud’s refresh mechanism.

---

## Technologies Used

- **Java 17**
- **Spring Boot 3.2.x**
- **Spring AOP**
- **Spring Boot Actuator**
- **Maven**

---

## Author

**Rajasekhar Pallala**  
Java Developer | Spring Boot Enthusiast | Cloud & Microservices Practitioner  

If you like this project, 🌟 **star the repo** and share your feedback!

---

## 📜 License

This project is open source :) , need any update to this - send me an email - pallala1989@gmail.com
