import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcUtils {
    private static Connection connection;
    private static Statement statement;

    //1. Step: Registration to the driver
    //2. Step: Create connection with database
    public static Connection connectToDatabase(String hostName,String databaseName,String username,String password) {

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        try {
            connection = DriverManager.getConnection("jdbc:postgresql://"+hostName+":5432/"+databaseName, username, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Connection is success!");
        return connection;
    }


    //3. Step: Create statement
    public static Statement createStatement() {

        try {
            statement =connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Statement created!");
        return statement;
    }

    //4. Step: Execute the query
    public static boolean execute(String query){
        boolean isExecute;

        try {
            isExecute = statement.execute(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Query Executed!");
        return isExecute;
    }

    //5. Step: Close the connection and statement
    public static void closeConnectionAndStatement(){
        try {
            connection.close();
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            if(connection.isClosed()&&statement.isClosed()){
                System.out.println("Connection and statement closed!");
            }else {
                System.out.println("Connection and statement not closed!");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }






}