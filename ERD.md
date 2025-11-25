# 🗂️ ERD Structure - Food Ordering System

---

## 🧍 users
| Column | Type | Note |
|--------|------|------|
| user_id | UUID | PK |
| username | VARCHAR | Unique |
| password | VARCHAR | Hashed |
| role | ENUM(USER, ADMIN) | RBAC |

---

## 🍔 food
| Column | Type | Note |
|--------|------|------|
| food_id | UUID | PK |
| name | VARCHAR | |
| description | TEXT | |
| price | DECIMAL | |
| category | VARCHAR | |
| available | BOOLEAN | |

---

## 📦 orders
| Column | Type | Note |
|--------|------|------|
| order_id | UUID | PK |
| user_id | UUID | FK → users |
| total_price | DECIMAL | |
| status | ENUM(PENDING, CONFIRMED, COOKING, DELIVERING, DONE, CANCELLED) | |
| createdAt | TIMESTAMP | |

---

## 🧾 order_items
| Column | Type | Note |
|--------|------|------|
| item_id | UUID | PK |
| order_id | UUID | FK → orders |
| food_id | UUID | FK → food |
| quantity | INT | |

---

## 🚚 delivery (optional)
| Column | Type | Note |
|--------|------|------|
| delivery_id | UUID | PK |
| order_id | UUID | FK → orders |
| status | ENUM(PREPARE, SHIPPING, ARRIVED) | |
| shipper | VARCHAR | |
| expected_time | TIMESTAMP | |

---

## 🔔 notifications (optional)
| Column | Type | Note |
|--------|------|------|
| notification_id | UUID | PK |
| user_id | UUID | FK → users |
| type | ENUM(SMS, EMAIL, PUSH) | |
| message | TEXT | |
| sent | BOOLEAN | |
