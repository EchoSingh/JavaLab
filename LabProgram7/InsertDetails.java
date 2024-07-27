import java.sql.*;
import java.util.*;

public class InsertDetails {
    public static void main(String[] args) {
        String usn, name, dept;
        Scanner obj = new Scanner(System.in);

        System.out.println("Enter Student Name:");
        name = obj.nextLine();

        System.out.println("Enter Student USN:");
        usn = obj.nextLine();

        System.out.println("Enter Student Dept:");
        dept = obj.nextLine();

        obj.close(); // Close the scanner

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Student", "root", "root");
            Statement stmt = con.createStatement();

            String q1 = "INSERT INTO student VALUES ('" + usn + "', '" + name + "', '" + dept + "')";
            int x = stmt.executeUpdate(q1);

            if (x > 0) {
                System.out.println("Successfully Inserted");
            } else {
                System.out.println("Insert Failed");
            }

            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
