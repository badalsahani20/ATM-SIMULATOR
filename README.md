# ATM Simulator

## Overview
The ATM Simulator is a Java-based desktop application that simulates the functionality of an ATM with a graphical user interface (GUI) built using Java Swing. Users can sign up, log in, and perform various banking transactions such as deposits, withdrawals, balance enquiries, and more. The project is organized under the `bankManagement` package and includes classes for user authentication and transaction handling.

## Features
- **User Registration**:
  - Start with the `Login` interface.
  - Click the "Sign Up" button to begin the registration process.
  - Fill out three signup forms (`SignUPOne`, `SignUPTwo`, `SignUPThree`) to register.
  - Upon completion, receive a unique card number and a 4-digit PIN.
- **Login**:
  - Use the provided card number and PIN to log in via the `Login` interface.
- **Transactions**:
  - After logging in, access the transaction menu (`Transactions` class) to perform:
    - **Deposit**: Add money to the account (`Deposit` class).
    - **Cash Withdrawal**: Withdraw money from the account (`Withdrawl` class).
    - **Fast Cash**: Quick withdrawal of predefined amounts (`FastCash` class).
    - **Mini Statement**: View recent transactions (`MiniStatement` class).
    - **PIN Change**: Update the ATM PIN (`PinChange` class).
    - **Balance Enquiry**: Check the account balance (`BalanceEnquiry` class).
    - **Exit**: Close the application.
- **GUI**: Built using Java Swing with a background image (`icons/atm.jpg`) for a realistic ATM interface.

## Project Structure
- **`bankManagement` Package**:
  - `Login.java`: Entry point for login and signup redirection.
  - `SignUPOne.java`, `SignUPTwo.java`, `SignUPThree.java`: Handle the three-step signup process.
  - `Transactions.java`: Main transaction menu after login.
  - `Deposit.java`: Manages deposit transactions.
  - `Withdrawl.java`: Manages cash withdrawals.
  - `FastCash.java`: Handles quick cash withdrawals.
  - `MiniStatement.java`: Displays transaction history.
  - `PinChange.java`: Allows PIN updates.
  - `BalanceEnquiry.java`: Shows account balance.
  - `Conn.java`: Likely handles database connectivity (if applicable).
- **`icons` Folder**: Contains `atm.jpg` for the GUI background.
- **Other Files**: `hs_err_pid*.log` and `replay_pid*.log` are error logs (excluded via `.gitignore`).

## Prerequisites
- **Java Development Kit (JDK)**: JDK 8 or higher.
- **Integrated Development Environment (IDE)**: Eclipse, VS Code, or any Java IDE.
- **Java Swing**: Used for the GUI (included in the JDK).

## Setup and Installation
1. **Clone the Repository**:
   ```bash
   git clone https://github.com/badalashani20/ATM-SIMULATOR.git
   cd ATM-SIMULATOR
   ```
2. **Open in an IDE**:
   - **Eclipse**: Import the project as a Java project.
   - **VS Code**: Open the folder and ensure the Java Extension Pack is installed.
3. **Set Up the JDK**:
   - Ensure a JDK is installed (`java -version`).
   - Configure the JDK in your IDE:
     - Eclipse: `Window > Preferences > Java > Installed JREs`.
     - VS Code: `File > Preferences > Settings`, search for `java.home`.
4. **Add Referenced Libraries** (if any):
   - If the project uses external JARs (e.g., for database connectivity), add them to the build path:
     - Eclipse: Right-click project > `Build Path > Add External Archives`.
     - VS Code: Add JARs to a `lib` folder and configure the classpath.
5. **Run the Application**:
   - Run `Login.java` to start the ATM simulator.

## Usage
1. **Launch the Application**:
   - Run `Login.java` to start the ATM simulator.
2. **Sign Up**:
   - From the login screen, click the "Sign Up" button.
   - Complete the three signup forms (`SignUPOne`, `SignUPTwo`, `SignUPThree`).
   - Receive a unique card number and a 4-digit PIN upon successful registration.
3. **Log In**:
   - Return to the login screen and enter your card number and PIN.
   - Log in to access the transaction menu.
4. **Perform Transactions**:
   - Choose from options like "Deposit," "Cash Withdraw," "Fast Cash," "Mini Statement," "Change Pin," "Balance Enquiry," or "Exit."
   - Follow the prompts to complete each transaction.
5. **Exit**:
   - Click the "Exit" button to close the application.

## Contributing
Contributions are welcome! Please fork the repository, make your changes, and submit a pull request.

## License
This project is licensed under the MIT License.

## Author
- **Badal Sahani** - [GitHub Profile](https://github.com/badalsahani20)
