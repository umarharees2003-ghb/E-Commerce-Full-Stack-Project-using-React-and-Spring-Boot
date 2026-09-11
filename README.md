# E-Commerce Full-Stack Application

A modern, full-featured e-commerce platform built with React and Spring Boot. This project demonstrates a complete end-to-end web application with a responsive frontend and robust backend API.

## 📋 Project Overview

This is a full-stack e-commerce application consisting of two main components:

- **Frontend**: React + Vite single-page application with a modern UI
- **Backend**: Spring Boot REST API with H2 database

The application allows users to browse products, add them to a shopping cart, manage quantities, checkout, and provides admin functionality to add and update products.

## 🏗️ Architecture

### Frontend (React)
Located in: `ecom-frontend-5-main/`

**Tech Stack:**
- React 18.2.0
- Vite 5.2.8 (build tool)
- React Router DOM 6.22.3 (routing)
- Axios 1.6.8 (HTTP client)
- Bootstrap 5.3.3 + React-Bootstrap (UI framework)
- React Icons 5.2.0 (icon library)

**Features:**
- Browse and search products by category
- Add/remove products from shopping cart
- Update product quantities in cart
- View product details with images
- Add new products (admin functionality)
- Update existing products
- Checkout with order summary
- Responsive design for mobile and desktop

### Backend (Spring Boot)
Located in: `ecom-project backend/`

**Tech Stack:**
- Spring Boot 4.0.6
- Java 25
- Spring Data JPA (ORM)
- H2 Database (in-memory)
- Lombok (reducing boilerplate)
- Spring Boot DevTools (hot reload)

**Features:**
- RESTful API for product management
- Image upload and retrieval
- CRUD operations on products
- In-memory H2 database with persistent schema

## 📦 Project Structure

```
ecom-project/
├── ecom-frontend-5-main/
│   ├── src/
│   │   ├── components/
│   │   │   ├── Home.jsx          # Main product listing page
│   │   │   ├── Navbar.jsx        # Navigation bar with cart icon
│   │   │   ├── Product.jsx       # Individual product display
│   │   │   ├── Cart.jsx          # Shopping cart view
│   │   │   ├── AddProduct.jsx    # Add new product form
│   │   │   ├── UpdateProduct.jsx # Edit product form
│   │   │   └── CheckoutPopup.jsx # Checkout modal
│   │   ├── Context/
│   │   │   └── Context.jsx       # React Context for state management
│   │   ├── App.jsx               # Main app component with routing
│   │   ├── main.jsx              # Application entry point
│   │   └── axios.jsx             # Axios instance configuration
│   ├── package.json
│   ├── vite.config.js
│   └── index.html
│
└── ecom-project backend/
    ├── src/main/
    │   ├── java/com/telusko/ecom_project/
    │   │   ├── EcomProjectApplication.java    # Spring Boot entry point
    │   │   ├── controller/
    │   │   │   └── productController.java    # REST API endpoints
    │   │   ├── model/
    │   │   │   └── Product.java              # Product entity
    │   │   ├── repo/
    │   │   │   └── productRepo.java          # JPA repository
    │   │   └── service/
    │   │       └── productService.java       # Business logic
    │   └── resources/
    │       ├── application.properties        # Spring Boot config
    │       └── data1.sql                     # Initial data
    └── pom.xml
```

## 📡 API Endpoints

### Products

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/api/product` | Retrieve all products |
| GET | `/api/product/{id}` | Retrieve a specific product by ID |
| POST | `/api/product` | Add a new product (multipart form-data) |
| PUT | `/api/product/{id}` | Update an existing product |
| DELETE | `/api/product/{id}` | Delete a product |
| GET | `/api/product/{productId}/image` | Retrieve product image |

### Request/Response Format

**Product Object:**
```json
{
  "id": 1,
  "name": "Product Name",
  "description": "Product description",
  "brand": "Brand Name",
  "price": 49.99,
  "category": "Electronics",
  "releaseDate": "2024-01-15",
  "productAvailable": true,
  "stockQuantity": 100,
  "imageName": "product.jpg",
  "imageType": "image/jpeg",
  "imageData": "<base64-encoded-image-data>"
}
```

## 🚀 Getting Started

### Prerequisites

**For Backend:**
- Java 25 or higher
- Maven 3.6+

**For Frontend:**
- Node.js 16+ and npm/yarn

### Backend Setup

1. Navigate to the backend directory:
```bash
cd "ecom-project backend"
```

2. Install dependencies and run:
```bash
mvn clean install
mvn spring-boot:run
```

The backend API will start on `http://localhost:8080`

**Database Access:**
- H2 Console: `http://localhost:8080/h2-console`
- URL: `jdbc:h2:mem:telusko`

### Frontend Setup

1. Navigate to the frontend directory:
```bash
cd ecom-frontend-5-main
```

2. Install dependencies:
```bash
npm install
```

3. Start the development server:
```bash
npm run dev
```

The frontend will be available at `http://localhost:5173` (default Vite port)

4. Build for production:
```bash
npm run build
```

## 🔑 Key Features

### For Users
- ✅ Browse all products with detailed information
- ✅ Filter products by category
- ✅ View product images
- ✅ Add products to shopping cart
- ✅ Update quantities in cart
- ✅ Remove items from cart
- ✅ Persistent cart (stored in localStorage)
- ✅ Checkout summary with total calculation
- ✅ Responsive mobile-friendly interface

### For Admins
- ✅ Add new products with images
- ✅ Edit existing product details
- ✅ Upload product images
- ✅ Manage product stock quantities
- ✅ Set product availability status

## 💾 Data Persistence

- **Frontend**: Uses `localStorage` to persist shopping cart data across sessions
- **Backend**: Uses H2 in-memory database with `spring.jpa.hibernate.ddl-auto=update` for automatic schema management
- **Images**: Stored as BLOB data in the database

## 🔄 Cross-Origin Configuration

The backend API has CORS enabled (`@CrossOrigin` annotation) to allow requests from the frontend application.

## 🛠️ Technologies Used

| Layer | Technologies |
|-------|--------------|
| Frontend | React, Vite, Axios, Bootstrap, React Router |
| Backend | Spring Boot, Spring Data JPA, H2, Lombok |
| Build Tools | Maven (Backend), npm + Vite (Frontend) |
| Database | H2 (In-Memory) |

## 📝 Available Scripts

### Frontend
```bash
npm run dev      # Start development server
npm run build    # Build for production
npm run lint     # Run ESLint
npm run preview  # Preview production build
```

### Backend
```bash
mvn spring-boot:run              # Run the application
mvn clean install                # Build the project
mvn test                         # Run tests
```

## 📚 State Management

The frontend uses React Context API for global state management:

```javascript
- AppContext: Manages products, cart items, and related operations
- Methods: addToCart(), removeFromCart(), updateStockQuantity()
```

## 🎨 UI Components

- **Navbar**: Navigation bar with cart icon and item count
- **Home**: Products grid view with category filtering
- **Product**: Individual product card with add to cart button
- **Cart**: Shopping cart with quantity controls and total
- **AddProduct**: Form to create new products with image upload
- **UpdateProduct**: Form to edit existing products
- **CheckoutPopup**: Modal for order review and checkout

## ⚙️ Configuration

### Backend (application.properties)
```properties
spring.application.name=ecom-project
spring.datasource.url=jdbc:h2:mem:telusko
spring.datasource.driverClassName=org.h2.Driver
spring.jpa.show-sql=true
spring.jpa.hibernate.ddl-auto=update
spring.jpa.defer-datasource-initialization=true
```

## 🔒 Future Enhancements

- User authentication and authorization
- Payment gateway integration
- Order history and tracking
- Product reviews and ratings
- Wishlist functionality
- Advanced product search and filtering
- Admin dashboard with analytics
- Email notifications

## 📄 License

This project is part of the Telusko Java Development Course.

## 👨‍💻 Author

Developed as a learning project demonstrating full-stack web development with React and Spring Boot.

---

**Note:** This is an educational project. The H2 database is in-memory, so data will be reset on application restart. For production use, migrate to a persistent database like PostgreSQL or MySQL.