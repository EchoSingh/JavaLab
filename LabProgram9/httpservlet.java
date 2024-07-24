import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

public class DatabaseAccess extends HttpServlet {

   public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
   
       String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
       String DB_URL = "jdbc:mysql://localhost/ise";

       String USER = "root";
       String PASS = "";

       response.setContentType("text/html");
       PrintWriter out = response.getWriter();
       String title = "Database Result";
        
       String docType =
         "<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\n";
      
       out.println(docType +
         "<html>\n" +
         "<head><title>" + title + "</title></head>\n" +
         "<body bgcolor=\"#f0f0f0\">\n" +
         "<h1 align=\"center\">" + title + "</h1>\n");

       Connection conn = null;
       Statement stmt = null;
       try {
         // Register JDBC driver
         Class.forName(JDBC_DRIVER);

         // Open a connection
         conn = DriverManager.getConnection(DB_URL, USER, PASS);

         // Execute SQL query
         stmt = conn.createStatement();
         String sql = "SELECT * FROM emp";
         ResultSet rs = stmt.executeQuery(sql);

         // Extract data from result set
         out.println("<table border=1>");
         out.println("<tr><th>ID</th><th>Name</th><th>Age</th></tr>");
         while (rs.next()) {
            //Retrieve by column name
            int id = rs.getInt(1);
            String name = rs.getString(2);
            String age = rs.getString(3);

            //Display values
            out.println("<tr><td>" + id + "</td><td>" + name + "</td><td>" + age + "</td></tr>");
         }
         out.println("</table>");
         out.println("</body></html>");

         // Clean-up environment
         rs.close();
         stmt.close();
         conn.close();
      } catch (SQLException se) {
         //Handle errors for JDBC
         out.println(se);
         se.printStackTrace();
      } catch (Exception e) {
         //Handle errors for Class.forName
         e.printStackTrace();
         out.println(e);
      } finally {
         // finally block used to close resources
         try {
            if (stmt != null) stmt.close();
         } catch (SQLException se2) {
         } // nothing we can do
         try {
            if (conn != null) conn.close();
         } catch (SQLException se) {
            se.printStackTrace();
         } //end finally try
      } //end try
   } //end doGet
} //end DatabaseAccess
