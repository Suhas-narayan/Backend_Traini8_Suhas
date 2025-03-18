# Backend_Traini8_Suhas

#### Project Overview

This is a Spring Boot application for managing a registry of government-funded training centers. It provides APIs for creating and retrieving training centers with filtering options.

___

#### Prerequisites

Ensure you have the following installed:
* java 11+
* Maven 3+
* PostgreSQL
___

#### Setup Instructions

### 1. Clone the Repository

$ git clone https://github.com/Suhas-narayan/Backend_Traini8_Suhas.git   
$ cd Backend_Traini8_Suhas

### 2. Configure the Database

#### 1.Start PostgreSQL and create a new database:  

   CREATE DATABASE traini8_db;

#### 2.Update src/main/resources/application.properties with your PostgreSQL credentials:  

  spring.datasource.url=jdbc:postgresql://localhost:5432/traini8_db  
  spring.datasource.username=yourUsername  
  spring.datasource.password=yourPassword  
  spring.jpa.hibernate.ddl-auto=validate  

#### 3.Build and Run the Application  
   $ mvn clean install  
   $ mvn spring-boot:run

The backend will start on http://localhost:8080  

#### 4.API Endpoints  
Create a Training Center  
  
POST (http://localhost:8080/api/training-centers )
Content-Type: application/json 

#### Request Body:  
  
{  
  "centerName": "Suhas Institute",  
  "centerCode": "ABC123456789",  
  "address": {  
    "detailedAddress": "BTM Layout ",  
    "city": "Bangalore",  
    "state": "Karnataka",  
    "pincode": "560076"  
  },  
  "studentCapacity": 100,  
  "coursesOffered": ["Java", "Python"],  
  "contactEmail": "suhasnarayan05@gmail.com",  
  "contactPhone": "6366503979"  
}  

### Get All Training Centers  

http://localhost:8080/api/training-centers  







  
