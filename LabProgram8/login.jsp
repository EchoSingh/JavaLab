<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Login</title>
</head>
<body>
    <%@ page import="java.sql.*" %>
    <% 
        String user = request.getParameter("user");
        String pwd = request.getParameter("pwd");
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "password");
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM users WHERE userid='" + user + "'");
        
        if (rs.next()) {
            if (rs.getString(3).equals(pwd)) {
                session.setAttribute("user", rs.getString(2));
                String name = (String) session.getAttribute("user");
                out.println("Welcome, " + name);
            } else {
                out.println("Invalid password");
            }
        } else {
            out.println("User not found");
        }
    %>
</body>
</html>
