package databaselayer;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
/**
 * This class is used to create the connection to the database
 * It is implemented as a singleton. The constructor is private to ensure that only one connection exists
 */


public class DBConnection {
	//Constants used to get access to the database
	private static final String  driver = "jdbc:sqlserver://hildur.ucn.dk";;
    private static final String  databaseName = ";databaseName=dmai0920_1086348";
    
    private static String  userName = "; user=dmai0920_1086348";
    private static String password = ";password=Password1!";
   
    private DatabaseMetaData databaseMetaData;
    private static Connection connection;
    
    // an instance of the class is generated
    private static DBConnection  instance = null;

    // the constructor is private to ensure that only one object of this class is created
    private DBConnection() {
    	String url = driver + databaseName + userName + password;

        try {
            //load of driver
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            System.out.println("Driver class loaded ok");
        } catch(Exception e) {
            System.out.println("Cannot find the driver");
            System.out.println(e.getMessage());
        }
        
        try {
            //connection to the database
        	connection = DriverManager.getConnection(url);
        	connection.setAutoCommit(true);
        	databaseMetaData = connection.getMetaData(); // get meta data
            System.out.println("Connection to " + databaseMetaData.getURL());
            System.out.println("Driver " + databaseMetaData.getDriverName());
            System.out.println("Database product name " + databaseMetaData.getDatabaseProductName());
        }//end try
        catch(Exception e) {
            System.out.println("Problems with the connection to the database:");
            System.out.println(e.getMessage());
            System.out.println(url);
        }//end catch
    }//end  constructor
	   
  //closeDb: closes the connection to the database
    public static void closeConnection() {
       	try {
       		connection.close();
            instance= null;
            System.out.println("The connection is closed");
        } catch (Exception e) {
            System.out.println("Error trying to close the database " +  e.getMessage());
        }
    }//end closeDB
		
    //getDBcon: returns the singleton instance of the DB connection
    public  Connection getDBconnection() {
       return connection;
    }
    
    //this method is used to get the instance of the connection
    public static DBConnection getInstance() {
        if (instance == null) {
          instance = new DBConnection();
        }
        
        return instance;
    }
    
    public static boolean instanceIsNull() {
       return (instance == null);
    }    
}//end DbConnection
