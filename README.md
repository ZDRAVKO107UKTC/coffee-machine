``` md
# Coffee Machine API

A Spring Boot backend application designed to manage coffee brewing processes, recipes, and inventory. The API controls a virtual coffee machine, including **payments** (pay in **BGN** or **EUR**, change returned in **EUR**).

## Features

- **Brewing Management**: Brew coffee based on a recipe and payment.
- **Payments (EUR base)**:
  - Recipe prices are treated as **EUR**
  - Customers can pay in **EUR** or **BGN**
  - Change is returned in **EUR**
- **Recipe Management**: Create, list, fetch, and delete recipes.
- **Inventory Tracking**: View and refill ingredients (water, milk, beans, sugar, cups).
- **Health Monitoring**: Endpoint to check system availability.

## Tech Stack

- **Java 17/23**
- **Spring Boot** (Web, Data JPA, Validation)
- **Jakarta EE** imports
- **Spring Data JPA** (Hibernate)
- **PostgreSQL**
- **Lombok**
- **Docker Compose**

## Prerequisites

- **JDK 17** or higher
- **Maven 3.x**
- **Docker** (optional, for PostgreSQL)

## Getting Started

### 1) Database Setup

The project uses PostgreSQL. Start it with Docker Compose:
```

bash docker-compose up -d```

### 2) Build and Run
```

bash ./mvnw spring-boot:run``` 

API base URL: `http://localhost:8080`

## API Endpoints

### Brewing + Payment

- `POST /api/brew` — Brew a coffee (deducts ingredients) and processes payment.

**Request body example (pay in BGN):**
```

json { "recipeId": 1, "paymentAmount": 5.00, "paymentCurrency": "BGN" }```

**Request body example (pay in EUR):**
```

json { "recipeId": 1, "paymentAmount": 3.00, "paymentCurrency": "EUR" }``` 

**Success response example (includes change in EUR):**
```

json { "status": "SUCCESS", "message": "Coffee brewed successfully.", "changeEur": 0.06 }```

**Possible errors:**
- `409 INSUFFICIENT_PAYMENT` — payment not enough (message includes missing EUR)
- `409 INSUFFICIENT_INVENTORY` — not enough ingredients/cups
- `400 VALIDATION_ERROR` — invalid request body

### Recipes

- `GET /api/recipes` — List all recipes
- `POST /api/recipes` — Create a recipe
- `GET /api/recipes/{id}` — Get recipe details
- `DELETE /api/recipes/{id}` — Delete a recipe

### Inventory

- `GET /api/inventory` — View current inventory
- `POST /api/inventory/refill` — Refill inventory

**Refill request example:**
```

json { "waterMl": 500, "milkMl": 200, "beansG": 100, "sugarG": 50, "cups": 10 }``` 

### Health

- `GET /api/health` — Service status

## Project Structure

- `com.school.coffeemachine.api.controllers`: REST controllers
- `com.school.coffeemachine.service`: Business logic (brewing, inventory, exchange rates)
- `com.school.coffeemachine.domain`: JPA entities
- `com.school.coffeemachine.repository`: Data access layer
- `com.school.coffeemachine.exception`: API error + exception handling

```
