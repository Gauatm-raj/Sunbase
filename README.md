# Sunbase
# Customer CRUD Application

## Description

This is a simple CRUD application for managing customers with JWT authentication.

## Technologies Used

- Spring Boot
- MySQL
- HTML/CSS/JS

## How to Run

1. Clone the repository.
2. Configure MySQL database in `application.properties`.
3. Run the Spring Boot application.
4. Open `index.html` in a web browser.

## API Endpoints

- `POST /authenticate`: Authenticate a user and return a JWT token.
- `POST /api/customers`: Create a new customer.
- `PUT /api/customers/{id}`: Update an existing customer.
- `GET /api/customers`: Get a list of customers with pagination.
- `GET /api/customers/{id}`: Get a customer by ID.
- `DELETE /api/customers/{id}`: Delete a customer by ID.

## Sync Feature

Click the "Sync" button on the customer list screen to sync customers from a remote API.

## Note

Do not hardcode credentials in the code. Use environment variables or configuration files.
