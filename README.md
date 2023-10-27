# QuotingProject-Capstone

### **1. Introduction**

**1.1 Purpose**

The purpose of the Quoting Project is to create a web-based application that enables customers to generate and manage quotes efficiently. This system will facilitate the selection of customers, location validation, product configuration, and billing calculations.

**1.2 Scope**

The Quoting Project aims to provide a comprehensive system for creating and managing quotes for customers. The system will allow existing customers to log in and new customers to sign up. It will enable users to select customers, manage account status, create quotes, and configure products for those quotes. This document outlines the functional and non-functional requirements of the Quoting Project.

**1.3 Technologies Used**

UI / Framework: Angular 16, HTML5 <br>
Middleware: Java/Spring Boot <br>
Backend: PostgreSQL <br>
Server: Embedded Tomcat <br>
Build Tool: Maven <br>
Code Quality: Sonarqube <br>

### **2. System Overview**

**2.1 System Architecture**

The Quoting Project follows a client-server architecture, with Angular serving as the frontend client and Spring Boot as the backend server. The system communicates with a PostgreSQL database for data storage and retrieval.

**2.2 User Roles**

Quote owner and customers - who manages quotes and product details

**2.3 Use Cases**

User registers to the system as new account if he is not existing customer <br>
User adds a new location if the location is not saved <br>
User validates the location that he entered <br>
User can select the products created in tile format <br>
User can persist the data to database while entering details of details of features and parameters <br>
User can see the billing page with cost of all products selected <br>

### **3. Functional Requirements**

**3.1 User Authentication**

Allow existing customers to log in and new customers to sign up.

**3.2 Customer Selection**

Display customer details and quote-related information.

**3.4 Location Management**

Display existing locations and allow the addition of new locations.

**3.4 Location Validation**

Validate location data to ensure accuracy.

**3.5 Product Selection**

Display and select products created through the Catalog project.

**3.6 Configuration**

Configure products, select locations, and enter parameter values.

**3.7 Billing**

Calculate and display billing information.

**3.8 Additional Features**<br>
API Integration: Expose APIs using Spring Boot REST controllers and implement Swagger for API testing.<br>
Java Concepts: Utilize Java concepts like Streams and Lombok for efficient coding.<br>
Database Design: Implement one-to-many and many-to-one relationships between tables for data integrity.

### **4. Non Functional Requirements**

**4.1 Performance**

The system should support users with less response for critical functions.

**4.2 Security**

User authentication must use industry-standard encryption, and sensitive data should be securely stored and access-controlled.

**4.3 Usability**

The user interface should follow best practices for design, and error messages must be clear and user-friendly.

**4.4 Reliability**

The system should have a good uptime and maintain data integrity through proper database design.

**4.5 Scalability**

The system architecture should be designed for scalability to accommodate increased load if necessary.

### **5. Testing**

A comprehensive testing strategy will be employed, including unit tests, integration tests, and user acceptance testing, to ensure the application functions correctly.

### **6. Functional Requirements**
- [ ] [Backend] (https://github.com/SowmyaBetina/QuotingProject-Capstone/tree/main/backend)
- [ ] [Frontend] (https://github.com/SowmyaBetina/QuotingProject-Capstone/tree/main/frontend)
- [ ] ER diagram
- [ ] Sonarqube report

