import java.sql.Connection;
import java.sql.Statement;
public class Runner {
    public static void main(String[] args) {
        //1. Step: Registration to the driver
        //2. Step: Create connection with database
        JdbcUtils.connectToDatabase("localhost","postgres","postgres","unutma");

        //3. Step: Create statement
        JdbcUtils.createStatement();

        //4. Step: Execute the query
        JdbcUtils.execute("CREATE TABLE workers(worker_id VARCHAR(50), worker_name VARCHAR(20), worker_salary INT )");

        //5. Step: Close the connection and statement
        JdbcUtils.closeConnectionAndStatement();







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
}