package Modele;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAO {
        private static String url="jdbc:mysql://localhost:3306/netflix";
        private static String username="root";
        private static String password="";

        private static Connection connection;
        public static Connection getInstance() {

            if (connection == null) {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                } catch (ClassNotFoundException e) {

                }

                try {
                    connection = DriverManager.getConnection(url, username, password);
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                return connection;
            }

            return null;
        }

}

