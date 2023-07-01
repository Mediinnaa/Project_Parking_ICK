import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DatabaseConnection {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/parking" ;
        String name = "name";
        String password = "password";

        try {
            Connection connection = DriverManager.getConnection(url, name, password);
            System.out.println("Lidhja me bazën e të dhënave u realizua me sukses!");
        } catch (SQLException e) {
            System.out.println("Gabim gjatë lidhjes me bazën e të dhënave: " + e.getMessage());
}
        }
}
