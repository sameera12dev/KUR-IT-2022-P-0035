package com.example;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/UserServlet")
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private Connection getConnection() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/userdb", "root", "sameera123");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String action = request.getParameter("action");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        try (Connection conn = getConnection()) {
            PreparedStatement stmt = null;
            int rows = 0;

            if ("register".equals(action)) {
                stmt = conn.prepareStatement("INSERT INTO users (name, email, password) VALUES (?, ?, ?)");
                stmt.setString(1, name);
                stmt.setString(2, email);
                stmt.setString(3, password);
                rows = stmt.executeUpdate();
                out.println(rows > 0 ? "✅ Registration successful!" : "❌ Registration failed.");
            } 
            else if ("update".equals(action)) {
                stmt = conn.prepareStatement("UPDATE users SET name=?, password=? WHERE email=?");
                stmt.setString(1, name);
                stmt.setString(2, password);
                stmt.setString(3, email);
                rows = stmt.executeUpdate();
                out.println(rows > 0 ? "✅ Update successful!" : "❌ Update failed.");
            } 
            else if ("delete".equals(action)) {
                stmt = conn.prepareStatement("DELETE FROM users WHERE email=?");
                stmt.setString(1, email);
                rows = stmt.executeUpdate();
                out.println(rows > 0 ? "✅ Deletion successful!" : "❌ Deletion failed.");
            }

            if (stmt != null) stmt.close();

        } catch (Exception e) {
            e.printStackTrace();
            out.println("❌ Error: " + e.getMessage());
        }
    }
}

