# Auction House Backend

This repository contains the backend code for the Auction House project. The backend is implemented using Java and the Spring Boot framework, and provides a RESTful API for interacting with the database.

## Getting Started

To get started, clone this repository to your local machine and import the project into your IDE of choice, I use Intellij. 

The backend uses MongoDB as the database, so you'll need to have MongoDB installed and running on your machine in order to run the application. You can download MongoDB from the official website at https://www.mongodb.com/download-center/community.

Once you have MongoDB installed and running, you'll need to create a database for the application to use. You can do this using the MongoDB shell or a GUI tool like Robo 3T.

After creating the database, you'll need to set the `spring.data.mongodb.uri` property in the `application.properties` file to the connection URI for your MongoDB instance.

## Running the Application

To run the application, simply run the `AuctionHouseApplication` class as a Java application. The application will start up and listen on port 8080 by default.

Once the application is running, you can interact with it using a REST client like Postman or curl. The API endpoints are defined in the various controller classes, and provide CRUD (Create, Read, Update, Delete) operations for the different entities in the database.

Postman api lib: https://grey-shuttle-436407.postman.co/workspace/cs.deals~664752e6-7b9c-4996-b677-68b556fb6671/collection/22858242-9fbfda99-8d76-4371-86c0-03456bb082f2?action=share&creator=22858242

## Project Structure

The project is structured according to standard Spring Boot conventions. The main package for the project is `com.project.AuctionHouse`, and contains the main `AuctionHouseApplication` class.

The `com.project.AuctionHouse.controller` package contains the various controller classes, which define the API endpoints and handle incoming requests.

The `com.project.AuctionHouse.service` package contains the service classes, which provide the business logic for the application.

The `com.project.AuctionHouse.repository` package contains the repository classes, which handle database operations using Spring Data MongoDB.

The `com.project.AuctionHouse.model` package contains the entity classes, which define the structure of the data stored in the database.

The `com.project.AuctionHouse.dto` package contains the DTO (Data Transfer Object) classes, which are used to transfer data between the different layers of the application.

The `com.project.AuctionHouse.mapper` package contains the mapper classes, which provide methods to convert between entity and DTO classes.

## Database Schema

The auction REST API utilizes a database with the following tables:

### User Table

The User table stores information about the users of the auction platform.

| Column   | Type    | Description                    |
|----------|---------|--------------------------------|
| username | string  | User's username                |
| password | string  | User's password (hashed)       |

### Listing Table

The Listing table represents the items being auctioned on the platform.

| Column        | Type     | Description                            |
|---------------|----------|----------------------------------------|
| id            | string   | Unique identifier for the listing       |
| username      | string   | Username of the listing owner           |
| product       | string   | Name of the product being listed        |
| price         | double   | Price of the product                    |
| endDate       | long     | End date of the listing (epoch)     |
| imageURL      | string   | URL of the image associated with listing|
| highestBidder | string   | Username of the highest bidder          |

### Bid Table

The Bid table tracks the bids placed on listings.

| Column      | Type     | Description                      |
|-------------|----------|----------------------------------|
| id          | string   | Unique identifier for the bid     |
| username    | string   | Username of the bidder            |
| listingId   | string   | Identifier of the listing being bid on |
| price       | double   | Amount of the bid                 |


## Conclusion

This backend provides a solid foundation for the Auction House project, and demonstrates proficiency in Java, Spring Boot, and MongoDB. The project structure follows standard conventions and provides a clear separation of concerns between the different layers of the application.
