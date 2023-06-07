
# My Employee-List project

This repository contains a simple Java project developed using the powerful Spring Framework. The project serves as an implementation of various components and features offered by Spring, including MVC, Lombok, DevTools, REST, security, data management, H2 Database, and Thymeleaf.


## Table of Contents

- [Overview](#Overview)
- [Features](#features)
- [User Roles and Database Access]("#User_Roles_and_Database_Access")
- [Usage](#usage)
- [Contributions](#Contributions)


## Overview

The purpose of this project is to provide a practical demonstration of how to leverage the Spring Framework to build robust and efficient Java applications. By exploring the code and structure of this project, developers can gain insights into best practices and techniques for utilizing Spring's wide range of functionalities.

## Features

#### The key features and technologies incorporated into this project are as follows:
* **MVC:** The Model-View-Controller architecture pattern is employed to ensure a clear separation of concerns, making the application highly maintainable and scalable.

* **Lombok:** Lombok is utilized to reduce boilerplate code by automatically generating getters, setters, constructors, and other commonly used methods.

* **DevTools:** Spring DevTools enable rapid development by providing automatic reloading of modified code and other useful developer-centric features.

* **REST:** The project leverages Spring's REST capabilities to build a robust and flexible API, facilitating smooth communication between the application and other systems.

* **Security:** Spring Security is employed to implement authentication and authorization mechanisms, ensuring secure access control to the application's resources.

* **Data:** Spring Data is utilized to simplify database interactions and provide seamless integration with various data storage solutions.

* **H2 Database:** The H2 Database, an in-memory database, is used to store and manage data during the project's execution, providing a lightweight and easily configurable option.

* **Thymeleaf:** Thymeleaf, a server-side Java template engine, is utilized for dynamic content rendering and seamless integration with Spring MVC.

## User Roles and Database Access

This project incorporates a role-based access control mechanism that restricts database operations based on the user's role. 

#### The following roles and their corresponding privileges are defined:

1. **Employee Role (John)**: 
Users assigned the employee role can only retrieve a list of employees from the database but are not allowed to modify any data.
2. **Manager Role (Mary):** Users assigned the manager role have the ability to retrieve the list of employees from the database, as well as add or update employee records.
3. **Admin Role (Susan):** Users assigned the admin role have full CRUD (Create, Read, Update, Delete) privileges on the database. They can update, delete, and add new employee records.
The role-based access control mechanism ensures that users can only perform actions that are appropriate for their assigned role, maintaining data integrity and security within the application.


| User        | Role    | Username    | Password | Description                                                                                                                                          |
| ----------- | ------- | ----- | -------- | ---------------------------------------------------------------------------------------------------------------------------------------------------- |
| `john`  | employee  | john | test1       | John can see just a list of employees |
| `mary`   | manager | mary | test2       | Mary as a manager can see the list but also can add or update an employee |
| `susan` | admin | susan | test3       | Susan is the admin. She has full Crud support on the database. She can view, add, update, delete an employee.                                                              |

## Usage

To get started with this project, please follow the instructions below.

1. Clone this repository to your local machine using git clone.
2. Ensure you have Java Development Kit (JDK) installed and properly configured.
3. Install the required dependencies by running mvn install or using your preferred build tool.
5. Run the application using mvn spring-boot:run or through your IDE's run configuration.
6. Access the application by navigating to http://localhost:7070 in your preferred web browser.
7. Login to the application using the credentials provided for each user role mentioned above and observe the different functionalities available based on the user's role.

## Contributions

Contributions to this project are highly welcomed. If you encounter any issues or have suggestions for improvements, please feel free to submit a pull request or open an issue.
