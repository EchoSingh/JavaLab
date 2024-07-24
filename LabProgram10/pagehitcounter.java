import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PageHitCounter extends HttpServlet {

   private int hitCount; 

   public void init() { 
      hitCount = 0;
   } 

   public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

      response.setContentType("text/html");

      hitCount++; 
      PrintWriter out = response.getWriter();
      String title = "Total Number of Hits";
      String docType = "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";
      
      out.println(docType +
         "<html>\n" +
            "<head><title>" + title + "</title></head>\n" +
            "<body bgcolor = \"#f0f0f0\">\n" +
               "<h1 align = \"center\">" + title + "</h1>\n" +
               "<h2 align = \"center\">" + hitCount + "</h2>\n" +
            "</body></html>"
      );
   }
   
   public void destroy() { 
   } 
}
