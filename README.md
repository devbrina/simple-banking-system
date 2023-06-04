# Simple Banking System

This is a simple banking system implemented in Java. It allows users to create a new client account, open a checking account, and perform various banking operations such as deposits, withdrawals, and balance inquiries.

## Features

- New client registration: Users can register as new clients by providing their name and CPF (Brazilian identification number).
- Checking account creation: Upon registration, a checking account is automatically created for the client.
- Optional savings account: Clients have the option to open a savings account in addition to the checking account.
- Deposit: Users can deposit funds into their checking or savings accounts.
- Withdrawal: Users can withdraw funds from their checking or savings accounts, subject to available balance.
- Balance inquiry: Users can check the current balance of their checking or savings accounts.
- Credit limit: Checking accounts have a credit limit that can be checked.
- Interest rate: Savings accounts have an interest rate that can be checked.

## Prerequisites

- Java Development Kit (JDK) installed
- IDE (Integrated Development Environment) for Java, such as Eclipse or IntelliJ

## Usage

1. Clone the repository to your local machine.
2. Open the project in your preferred Java IDE.
3. Build and run the project.
4. Follow the on-screen prompts to navigate through the banking system's functionalities.

## Folder Structure

The folder structure of the project is as follows:

	simple-banking-system/
	├── src/
	│   ├── simplebankingsystem/
	│   │   ├── controller/
	│   │   │   └── BankController.java
	│   │   ├── model/
	│   │   │   ├── Account.java
	│   │   │   ├── CheckingAcct.java
	│   │   │   └── SavingsAcct.java
	│   │   ├── ui/
	│   │   │   ├── BankUI.java
	│   │   │   └── Main.java
	│   │   └── util/
	│   │       └── CommonUtils.java
	│   └── README.md
	├── docs/
	│   ├── UML.pdf
	│   └── other_documents.pdf
	└── .gitignore



## Future Improvements

1. **Implementation of Tests**: Implement unit tests and integration tests to ensure the correctness and robustness of the application. Consider using testing frameworks like JUnit or TestNG.

2. **Framework Integration**: Integrate popular Java frameworks like Spring and Angular to enhance the application's development process and leverage their features for dependency injection, MVC architecture, and frontend development.

3. **Frontend Development**: Enhance the user experience by creating a graphical user interface (GUI) using a frontend framework such as JavaFX, Swing, or Angular. This will provide a more intuitive and interactive interface for users.

4. **Database Integration**: Implement database functionality to store and retrieve account information, transactions, and user data. Consider using a database management system like MySQL or PostgreSQL and an Object-Relational Mapping (ORM) framework like Hibernate or Spring Data for seamless integration.

5. **Containerization with Docker**: Containerize the application using Docker to ensure portability and easy deployment across different environments. Create a Dockerfile and docker-compose.yml file to define the application's dependencies and configuration.

These future improvements will add more functionality, usability, scalability, and maintainability to the banking system, making it a more robust and efficient solution for end-users.


## Documentos

- [Diagramas UML](docs/diagramas.pdf)



## Contributing

Contributions to this simple banking system project are welcome. If you have any ideas, improvements, or bug fixes, feel free to submit a pull request.

## License

This project is licensed under the [MIT License](LICENSE).
