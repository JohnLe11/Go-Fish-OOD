import java.sql.*;
import java.util.Scanner;
public class Account {
    private String accountName;
    private String password;

    public Account(String accountName, String password) {
        this.accountName = accountName;
        this.password = password;
    }
    public Account() {
        // Default constructor with no arguments
    }
    //database hosted at https://www.freemysqlhosting.net/account/
    public void saveToDatabase() {
        Scanner scanner = new Scanner(System.in);
    
        // Prompt the user for the account name and password
        System.out.print("Enter account name (at least 6 characters): ");
        String name = scanner.nextLine();
        System.out.print("Enter account password (at least 6 characters): ");
        String password = scanner.nextLine();
    
        // Check if the username and password meet the length requirement
        if (name.length() < 6 || password.length() < 6) {
            System.out.println("Username and password must be at least 6 characters long.");
            return;
        }
    
        // Check if the account already exists in the database
        String url = "jdbc:sqlserver://gofish.database.windows.net:1433;database=gofishdatabase;user=admin1@gofish;password={your_password_here};encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
        String user = "admin1@gofish.database.windows.net";
        String dbPassword = "Abc8008135";
        boolean accountExists = false;
    
        try (Connection conn = DriverManager.getConnection(url, user, dbPassword)) {
            String selectSql = "SELECT COUNT(*) FROM Account WHERE name = ? AND password = ?";
    
            try (PreparedStatement statement = conn.prepareStatement(selectSql)) {
                statement.setString(1, name);
                statement.setString(2, password);
    
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next() && resultSet.getInt(1) > 0) {
                        // Account already exists in the database
                        System.out.println("Welcome back!");
                        accountExists = true;
                    }
                }
            } catch (SQLException e) {
                System.out.println("Error querying database:");
                e.printStackTrace();
                return;
            }
        } catch (SQLException e) {
            System.out.println("Error connecting to database:");
            e.printStackTrace();
            return;
        }
    
        if (!accountExists) {
            // Ask the user if they would like to create a new account
            System.out.print("There is no account with this name and password. Would you like to create a new account? (y/n) ");
            String input = scanner.nextLine().toLowerCase();
            if (input.equals("y")) {
                // Insert the account name and password into the database using JDBC
                try (Connection conn = DriverManager.getConnection(url, user, dbPassword)) {
                    String insertSql = "INSERT INTO Account (name, password) VALUES (?, ?)";
    
                    try (PreparedStatement statement = conn.prepareStatement(insertSql)) {
                        statement.setString(1, name);
                        statement.setString(2, password);
                        statement.executeUpdate();
                        System.out.println("Account Created!");
                    } catch (SQLException e) {
                        System.out.println("Error inserting account into database:");
                        e.printStackTrace();
                    }
                } catch (SQLException e) {
                    System.out.println("Error connecting to database:");
                    e.printStackTrace();
                }
            } else {
                System.out.println("No account created. Continuing as Guest");
            }
        }
    }
}