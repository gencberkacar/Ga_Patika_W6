import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBConnect {

    //We have defined the information to connect to the database
    public static final String DB_URL = "jdbc:mysql://localhost/Information";
    public static final String DB_USER = "root";
    public static final String DB_PASS = "mysql";

    public static void main(String[] args) {

        Connection connect = null;
        String resSql = "SELECT * FROM Employees"; // We have indicated the question to be asked
        try {
            connect = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            Statement st = connect.createStatement();
            ResultSet data = st.executeQuery(resSql); // We assign data to the data variable
            System.out.printf("%-5s %-20s %-20s %-10s%n", "ID", "Employee Name", "Employee Position", "Employee Salary");
            System.out.println("-------------------------------------------------------------");

            while (data.next()) {  // We used a while loop to suppress the table
                int id = data.getInt("employee_id");
                String name = data.getString("employee_name");
                String position = data.getString("employee_position");
                int salary = data.getInt("employee_salary");
                System.out.printf("%-5s %-20s %-20s %-10s%n", id, name, position, salary);
            }

            System.out.println("-------------------------------------------------------------");
            data.close();
            st.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


}