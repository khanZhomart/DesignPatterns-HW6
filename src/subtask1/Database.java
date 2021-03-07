package subtask1;

import java.sql.*;

public class Database {
    private static final String URL = "jdbc:postgresql://localhost:5432/company";
    private static final String DRIVER = "org.postgresql.Driver";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "100591";

    private static Database instance;

    Connection connection;
    PreparedStatement preparedStatement;
    ResultSet result;

    private Database() {
        try {
            Class.forName(DRIVER);

            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("\n[Connection Established]\n");
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    public static Database getInstance() {
        if (Database.instance == null)
            Database.instance = new Database();

        return Database.instance;
    }

    public void query(String query) {
        try {
            preparedStatement = connection.prepareStatement(query);

            result = preparedStatement.executeQuery();

            while (result.next())
                System.out.println(result.toString());
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}