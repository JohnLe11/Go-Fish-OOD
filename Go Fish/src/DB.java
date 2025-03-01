public class BD {
            // Connect to MySQL database
            Connection conn = null;
            Statement stmt = null;
            try {
                Class.forName("com.mysql.cj.jdbc.Driver"); // Load MySQL JDBC driver
                String url = "jdbc:mysql://localhost:3306/mydatabase"; // Database URL
                String user = "root"; // Database user
                String password = "mypassword"; // Database password
                conn = DriverManager.getConnection(url, user, password); // Establish database connection
                stmt = conn.createStatement();
    
                // Save game ID to database
                String sql = "INSERT INTO games (game_id) VALUES ('" + gameID + "')";
                stmt.executeUpdate(sql);
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (stmt != null) stmt.close(); // Close statement
                    if (conn != null) conn.close(); // Close connection
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
    
}
