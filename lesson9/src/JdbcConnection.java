import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnection {
    private static Connection con;

    public static void init() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");//создание подключения со службой MySQL
        con = DriverManager.getConnection("jdbc:mysql://localhost/test_db","User1","1234");
    }

    public static Connection getConnection(){
        return con;
    }
}
