package Com_Utility;

import java.sql.*;

public class SQL {

    public static void main(String[] args) throws SQLException {

        // Data We Want To Validate from the Grid List
        String[][] gridData = {
            {"we can add string data which want to fetch"},
            
        };

        // Database connection variables
        String url = "jdbc:mysql://localhost:3306/database_name"; // Replace with your actual database name
        String username = "your_db_username"; // Replace with your actual username
        String password = "your_db_password"; // Replace with your actual password

        // Establish a connection to the database
        Connection con = DriverManager.getConnection(url, username, password);

        // Loop through gridData to validate or insert records
        for (String[] row : gridData) {
            String cust_Firstname = row[0];
            String cust_JoiningDate = row[1];
            String cust_State = row[2];
            String cust_Town = row[3];
            String cust_Mobile = row[4];
            String cust_PANNo = row[5];
            String cust_Status = row[6];

            // Construct the SQL query directly with values from gridData (string concatenation)
            String query = "SELECT * FROM customers WHERE firstname = '" + cust_Firstname + "' " +
                           "AND mobile = '" + cust_Mobile + "' " +
                           "AND pan_no = '" + cust_PANNo + "'";

            // Create a Statement object to execute the query
            Statement stmt = con.createStatement();

            // Execute the query and get the result set
            ResultSet rs = stmt.executeQuery(query);

            // Track if a matching record was found
            boolean status = false;

            // Iterate over the result set and compare the data
            while (rs.next()) {
                String Firstname = rs.getString("firstname");
                String Mobile = rs.getString("mobile");
                String PANNo = rs.getString("pan_no");

                if (cust_Firstname.equals(Firstname) && cust_Mobile.equals(Mobile) && cust_PANNo.equals(PANNo)) {
                    System.out.println("Test Pass: Data Matched Successfully for " + cust_Firstname);
                    status = true;
                    break; // Exit the loop once a match is found
                }
            }

            if (!status) {
                System.out.println("Test failed: No Data match for " + cust_Firstname);
            }

            rs.close();
            stmt.close();
        }

        // Clean up and close resources
        con.close();
    }
}
