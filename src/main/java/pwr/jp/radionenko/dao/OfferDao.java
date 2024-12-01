package pwr.jp.radionenko.dao;

import pwr.jp.radionenko.model.Offer;
import pwr.jp.radionenko.util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OfferDao {

    public List<Offer> findAll() {
        List<Offer> offers = new ArrayList<>();
        String query = "SELECT * FROM offer";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                Offer offer = new Offer(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("description"),
                        rs.getDouble("price")
                );
                offers.add(offer);
            }

        } catch (SQLException e) {
            System.err.println("Error fetching offers: " + e.getMessage());
        }

        return offers;
    }

    public void save(Offer offer) {
        if (offer == null || offer.getName() == null || offer.getName().isEmpty() || offer.getPrice() <= 0) {
            throw new IllegalArgumentException("Offer data is invalid");
        }

        String query = "INSERT INTO offer (name, description, price) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, offer.getName());
            pstmt.setString(2, offer.getDescription());
            pstmt.setDouble(3, offer.getPrice());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Error saving offer: " + e.getMessage());
        }
    }

}

