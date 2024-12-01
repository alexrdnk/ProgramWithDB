package pwr.jp.radionenko.dao;

import pwr.jp.radionenko.model.Order;
import pwr.jp.radionenko.util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDao {

    public List<Order> findAll() {

        List<Order> orders = new ArrayList<>();

        String query = "SELECT * FROM orders";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                Order order = new Order(
                        rs.getInt("id"),
                        rs.getInt("clientId"),
                        rs.getInt("organizerId"),
                        rs.getInt("offerId"),
                        rs.getString("status"),
                        rs.getString("creatingDate"),
                        rs.getString("realizationDate")
                );
                orders.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }

    public void save(Order order) {
        String query = "INSERT INTO orders (clientId, organizerId, offerId, status, creatingDate) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, order.getClientId());
            pstmt.setInt(2, order.getOrganizerId());
            pstmt.setInt(3, order.getOfferId());
            pstmt.setString(4, order.getStatus());
            pstmt.setString(5, order.getCreatingDate());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Order order) {
        String query = "UPDATE orders SET status = ?, realizationDate = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, order.getStatus());
            pstmt.setString(2, order.getRealizationDate());
            pstmt.setInt(3, order.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Order> findByClientId(int clientId) {
        List<Order> orders = new ArrayList<>();
        String query = "SELECT * FROM orders WHERE clientId = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, clientId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Order order = new Order(
                        rs.getInt("id"),
                        rs.getInt("clientId"),
                        rs.getInt("organizerId"),
                        rs.getInt("offerId"),
                        rs.getString("status"),
                        rs.getString("creatingDate"),
                        rs.getString("realizationDate")
                );
                orders.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }


}
