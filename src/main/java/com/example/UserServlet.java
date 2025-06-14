package com.example;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private Connection getConnection() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/userdb", "root", "sameera123");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String action = request.getParameter("action");
        String fullName = request.getParameter("full_name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        try (Connection conn = getConnection()) {
            PreparedStatement stmt = null;
            int rows = 0;

            switch (action) {
                case "register":
                    stmt = conn.prepareStatement("INSERT INTO user (full_name, email, password) VALUES (?, ?, ?)");
                    stmt.setString(1, fullName);
                    stmt.setString(2, email);
                    stmt.setString(3, password);
                    rows = stmt.executeUpdate();
                    out.println(rows > 0 ? "✅ Registered successfully." : "❌ Failed to register.");
                    break;

                case "update":
                    stmt = conn.prepareStatement("UPDATE user SET email=?, password=? WHERE full_name=?");
                    stmt.setString(1, email);
                    stmt.setString(2, password);
                    stmt.setString(3, fullName);
                    rows = stmt.executeUpdate();
                    out.println(rows > 0 ? "✅ Updated successfully." : "❌ Update failed.");
                    break;

                case "delete":
                    stmt = conn.prepareStatement("DELETE FROM user WHERE full_name=?");
                    stmt.setString(1, fullName);
                    rows = stmt.executeUpdate();
                    out.println(rows > 0 ? "✅ Deleted successfully." : "❌ Delete failed.");
                    break;
            }

            if (stmt != null) stmt.close();

        } catch (Exception e) {
            e.printStackTrace();
            out.println("❌ Error: " + e.getMessage());
        }
    }
}
