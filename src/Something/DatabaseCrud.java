package Something;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSetMetaData;

public class DatabaseCrud { // I COPIED ALL THESE LINES, THANKS MATT LY!
     private static String dbURL = "jdbc:derby:c:\\Users\\Anthony Pham\\workspacenew\\Database";
  //	private static String dbURL = "jdbc:derby://localhost:8080/UOMe/Database";
    private static String tableName = "PERSONS";
    // jdbc Connection
    private static Connection conn = null;
    private static Statement stmt = null;
	
   
    


		public static void insertdb(String Input1){		//This creates a function. Thanks Matt Ly!
			System.out.println(Input1);
		    createConnection();
	        insertpersons(Input1);
		    shutdown();
		
	}
		
		private static void createConnection()
	    {
	        try
	        {
	            Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
	            //Get a connection
	            conn = DriverManager.getConnection(dbURL); 
	        }
	        catch (Exception except)
	        {
	            except.printStackTrace();
	        }
	    }
		
	    private static void insertpersons(String FIRSTNAME)
	    {
	        try
	        {
	            stmt = conn.createStatement();
	         //   stmt.execute("insert into " + tableName + " FIRSTNAME values (" +
	         //           FIRSTNAME + "')");
	              stmt.execute("insert into PERSONS (FIRSTNAME) VALUES ('testname')");
	            stmt.close();
	            
	            //
	        }
	        catch (SQLException sqlExcept)
	        {
	            sqlExcept.printStackTrace();
	        }
	    }
	    
		
		 private static void shutdown()
		    {
		        try
		        {
		            if (stmt != null)
		            {
		                stmt.close();
		            }
		            if (conn != null)
		            {
		                DriverManager.getConnection(dbURL + ";shutdown=true");
		                conn.close();
		            }           
		        }
		        catch (SQLException sqlExcept)
		        {
		            
		        }

		    }
}