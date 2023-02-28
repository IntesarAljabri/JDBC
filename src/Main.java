import java.sql.*;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        String url = "jdbc:sqlserver://localhost:1433;" +
                "databaseName=MyQuary;" +
                "encrypt=true;" +
                "trustServerCertificate=true";

        String user = "sa";
        String pass = "root";

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Artist Id");
        Integer Art = scanner.nextInt();

        System.out.println("Enter Artist Name");
        String name = scanner.nextLine();

        


        Connection con = null;

        try {

            Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
            DriverManager.registerDriver(driver);

            con = DriverManager.getConnection(url, user, pass);


            Statement st = con.createStatement();
            
            String sql = "insert into Artist values('" + Art + "'," + name + ")";

            Integer m = st.executeUpdate(sql);
            if (m >= 1) {
                System.out.println("inserted successfully : " + sql);
            } else {
                System.out.println("insertion failed");
            }

            String sql1 = "Select * from Artist";
            ResultSet resultSet = st.executeQuery(sql1);


            while (resultSet.next()) {
                System.out.println(resultSet.getInt("Art"));
                System.out.println(resultSet.getString("name"));
           
            }
            con.close();
        } catch (Exception ex) {
            System.err.println(ex);
        }

    }
}
