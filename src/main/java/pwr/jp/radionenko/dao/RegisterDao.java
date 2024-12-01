package pwr.jp.radionenko.dao;

import pwr.jp.radionenko.model.Register;
import pwr.jp.radionenko.util.DatabaseConnection;

import java.sql.*;

public class RegisterDao {

    public boolean registerUser(Register user) {
        String query = "INSERT INTO Client (username, password, name) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPassword());
            stmt.setString(3, user.getName());
            int rowsInserted = stmt.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public int getUserId(String username, String password) {
        String query = "SELECT id FROM Client WHERE username = ? AND password = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt("id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1; // Return -1 if authentication fails
    }


}
