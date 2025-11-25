# 🏗️ Food Ordering System - Development Todo List

## 📋 Tổng quan MVP (Minimum Viable Product)

MVP của hệ thống Food Ordering bao gồm các chức năng cơ bản sau để có thể chạy được sản phẩm tối thiểu:

- [ ] **Authentication Service**: Đăng ký, đăng nhập người dùng (customer & admin)
- [ ] **Menu Service**: Quản lý danh sách món ăn, danh mục
- [ ] **Order Service**: Tạo đơn hàng, quản lý trạng thái đơn hàng
- [ ] **Inventory Service**: Kiểm tra và cập nhật tồn kho
- [ ] **Payment Service**: Xử lý thanh toán cơ bản (mô phỏng)
- [ ] **Notification Service**: Gửi thông báo đơn hàng qua email/SMS
- [ ] **API Gateway**: Routing và bảo mật API
- [ ] **Eureka Server**: Service discovery
- [ ] **Docker Compose**: Chạy toàn bộ hệ thống với Docker

**Định nghĩa Done cho MVP:**
- [ ] Tất cả service chạy được trên Docker
- [ ] API Swagger hoạt động
- [ ] Đặt hàng từ menu đến thanh toán thành công
- [ ] RabbitMQ event flow hoạt động

---

## 🏛️ Cấu trúc Dự án & Thiết lập Cơ bản

### 1. Thiết lập Repository & Branch
- [ ] Tạo branch `develop` từ `main`
- [ ] Cấu hình Git Flow theo quy tắc branch
- [ ] Thiết lập CI/CD pipeline (nếu cần)

### 2. Cấu hình Docker & Infrastructure
- [ ] Cập nhật `docker-compose.yml` với tất cả service
- [ ] Cấu hình PostgreSQL/MySQL database
- [ ] Cấu hình RabbitMQ
- [ ] Test docker-compose up/down

### 3. Eureka Server Setup
- [ ] Tạo Spring Boot project cho `eureka-server`
- [ ] Cấu hình Eureka server properties
- [ ] Test service discovery

### 4. API Gateway Setup
- [ ] Tạo Spring Boot project cho `api-gateway`
- [ ] Cấu hình Spring Cloud Gateway
- [ ] Routing rules cho tất cả service
- [ ] Bảo mật JWT (nếu cần)

---

## 🔧 Phát triển từng Microservice (Theo DDD)

### Service-Auth
- [ ] Thiết lập cấu trúc DDD (domain/application/infrastructure/interfaces)
- [ ] Domain: User model, repository interface, service
- [ ] Application: LoginUseCase, RegisterUseCase
- [ ] Infrastructure: JPA repository, JWT config
- [ ] Interface: AuthController (REST API)
- [ ] Swagger documentation
- [ ] Unit tests

### Service-Menu
- [ ] Domain: MenuItem, Category models
- [ ] Application: GetMenuUseCase, CreateMenuItemUseCase
- [ ] Infrastructure: Database repository
- [ ] Interface: MenuController
- [ ] RabbitMQ event cho menu updates

### Service-Order
- [ ] Domain: Order, OrderItem models
- [ ] Application: CreateOrderUseCase, UpdateOrderStatusUseCase
- [ ] Infrastructure: Repository + RabbitMQ producer
- [ ] Interface: OrderController
- [ ] Event: OrderCreated, OrderStatusChanged

### Service-Inventory
- [ ] Domain: InventoryItem model
- [ ] Application: CheckInventoryUseCase, UpdateInventoryUseCase
- [ ] Infrastructure: Repository + RabbitMQ consumer
- [ ] Event listeners cho inventory updates

### Service-Payment
- [ ] Domain: Payment model
- [ ] Application: ProcessPaymentUseCase
- [ ] Infrastructure: Payment gateway integration (mô phỏng)
- [ ] Event: PaymentSuccess, PaymentFailed

### Service-Notification
- [ ] Domain: Notification model
- [ ] Application: SendNotificationUseCase
- [ ] Infrastructure: Email/SMS service
- [ ] RabbitMQ consumers cho các events

---

## 📋 Rules Chính thức cho Việc Code

### Branch & Commit Rules
- [ ] Tuân thủ naming convention: `feature/service/feature-name`
- [ ] Commit message theo format: `type(service): message`
- [ ] Không commit trực tiếp vào `main`

### Code Structure Rules
- [ ] Mỗi service theo cấu trúc DDD bắt buộc
- [ ] Controller → UseCase → Domain Service → Repository
- [ ] Không gọi repository trực tiếp từ controller

### Naming Standards
- [ ] Class: PascalCase (`OrderCreatedEvent`)
- [ ] Variable: camelCase (`orderStatus`)
- [ ] DTO: `[Action][Entity]Dto` (`CreateOrderRequestDto`)
- [ ] UseCase: `VerbEntityUseCase` (`CreateOrderUseCase`)

### API Rules
- [ ] RESTful naming: `GET /orders`, `POST /orders`
- [ ] Không dùng động từ trong URL
- [ ] HTTP methods đúng chuẩn

### RabbitMQ Rules
- [ ] Exchange: `service.exchange` (vd: `orders.exchange`)
- [ ] Queue: `service.action.queue` (vd: `orders.created.queue`)
- [ ] Routing key: `service.action` (vd: `order.created`)

### Logging & Error Handling
- [ ] Log format: `[LEVEL] [SERVICE] [TRACE_ID] ACTION: message`
- [ ] Error response JSON chuẩn
- [ ] Swagger UI cho tất cả API

### Testing & Documentation
- [ ] Unit tests cho business logic
- [ ] Integration tests cho API
- [ ] README.md cho mỗi service
- [ ] ERD diagram cập nhật

---

## 🚀 Deployment & Production Ready

### Docker & Containerization
- [ ] Dockerfile cho mỗi service
- [ ] Multi-stage build để tối ưu image size
- [ ] Environment variables configuration

### Monitoring & Logging
- [ ] Centralized logging (ELK stack)
- [ ] Health checks cho tất cả service
- [ ] Metrics collection

### Security
- [ ] JWT authentication
- [ ] API rate limiting
- [ ] Input validation
- [ ] HTTPS configuration

### Performance
- [ ] Database indexing
- [ ] Caching strategy (Redis)
- [ ] Load balancing

---

## 📊 Definition of Done cho từng Task

- [ ] Code compile và chạy thành công
- [ ] Unit tests pass
- [ ] API endpoints hoạt động (test qua Swagger)
- [ ] RabbitMQ events gửi/nhận đúng
- [ ] Docker container build thành công
- [ ] Commit message đúng format
- [ ] Code review và merge vào develop

---

**Version: v1.0 - Initial Todo List**  
**Updated: 25/11/2025**  
**Based on: PROJECT_RULES_AND_STANDARDS.md v1.1**

*Hướng dẫn sử dụng: Check [x] khi hoàn thành task. Sử dụng GitHub Issues để track progress chi tiết.*