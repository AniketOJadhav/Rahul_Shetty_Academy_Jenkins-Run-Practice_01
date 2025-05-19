package DataBase_Fosroc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import Com_Utility.ObjectRepo;

public class New_Distributor_Database_Conn {

	
    Connection con;
    Statement stmt;
    ResultSet rs;

    // Expected values
    String expectedName = "Pratik Thakur Enterprises and sons";
    String expectedCode = "10041";
    String expectedId = "31";
    String expectedBeat = "Koregaon Park";
    
    
	@BeforeSuite
    public void setupSuite() {
		
        ObjectRepo.initializeReport();  // Important: Initializes the Extent report
        
        
    }
    
    

    @BeforeClass
    public void setUp() throws Exception {
        String jdbcURL = "jdbc:sqlserver://172.25.0.74:1433;databaseName=Fosroc_UAT;encrypt=true;trustServerCertificate=true;loginTimeout=10";
        String username = "Test_Team";
        String password = "Pass@2025";

        // Load the JDBC driver
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

        // Create connection and statement
        con = DriverManager.getConnection(jdbcURL, username, password);
        stmt = con.createStatement();
        
        
    }
    

    @Test
    public void verifyDistributorData() throws Exception {
        String query = "SELECT * FROM DistributorMaster";
        rs = stmt.executeQuery(query);

        boolean matchFound = false;

        while (rs.next()) {
            String name = rs.getString("DistributorName");
            String code = rs.getString("DistributorCode");
            String id = rs.getString("Id");
            String beat = rs.getString("BeatName");

            if (expectedName.equals(name) && expectedCode.equals(code)
                    && expectedId.equals(id) && expectedBeat.equals(beat)) {

                String matchedData = String.format("Test Pass: Data Matched Successfully => %s | %s | %s | %s", name, code, id, beat);

                ObjectRepo.startTestAndLog_1_SS("Distributor Data Validation", matchedData, () -> {
                    Assert.assertTrue(true);
                });

                matchFound = true;
                break;
            }
        }

        if (!matchFound) {
            ObjectRepo.startTestAndLog_1_SS("Distributor Data Validation", "Test Failed: No matching distributor data found.",
                    () -> Assert.fail("No matching distributor data found in DB."));
        }
    }

    @AfterClass
    public void tearDown() throws Exception {
        if (rs != null) rs.close();
        if (stmt != null) stmt.close();
        if (con != null) con.close();
    }

    @AfterSuite
    public void tearDownSuite() {
        ObjectRepo.finalizeReport();
    }
}
