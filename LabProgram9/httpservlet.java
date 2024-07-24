import java.io.*;
import java.sql.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class DataAccess extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String JDBC_DRIVER = "com.mysql.jdbc.Driver";
        String DB_URL = "jdbc:mysql://localhost/testdb";
        String USER = "root";
        String PASS = "root";
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String title = "Database Request";
        String docType = "<!DOCTYPE html public \"-//w3c//dtd html 4.01 transitional//en\">\n";
        
        out.println(docType + "<html>\n" + "<head><title>" + title + "</title></head>\n" + 
                    "<body bgcolor=\"#f0f0f0\">\n" + 
                    "<h1 align=\"center\">" + title + "</h1>\n");
        
        try {
            Class.forName(JDBC_DRIVER);
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM emp";
            ResultSet rs = stmt.executeQuery(sql);
            
            out.println("<table border=1><tr><th>ID</th><th>Name</th><th>Age</th></tr>");
            
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String age = rs.getString(3);
                
                out.println("<tr><td>" + id + "</td><td>" + name + "</td><td>" + age + "</td></tr>");
            }
            
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            out.println(se);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        out.println("</body></html>");
    }
}
